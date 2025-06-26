package api.kindergartensb.controller;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.service.GroupGetter;
import api.kindergartensb.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/groups")

public class GroupController {

    private final GroupService service;
    private final GroupMapper groupMapper;
    private final GroupGetter groupGetter;

    public static final int MAX_CHILD = 20;

    public GroupController(GroupService service,
                           GroupMapper groupMapper,
                           GroupGetter groupGetter) {
        this.service = service;
        this.groupMapper = groupMapper;
        this.groupGetter = groupGetter;
    }

    @PostMapping("/create")
    public ResponseEntity<GroupDTO> create(@RequestBody GroupDTO groupDTO) {
        int MAX_CHILD = this.MAX_CHILD;

        if (groupDTO.getKinderList() != null && groupDTO.getKinderList().size() > MAX_CHILD) {
            return ResponseEntity
                    .badRequest()
                    .body(null);

        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(groupDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(groupGetter.getById(id));
    }

}

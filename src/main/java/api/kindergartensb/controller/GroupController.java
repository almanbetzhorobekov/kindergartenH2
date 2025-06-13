package api.kindergartensb.controller;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
//todo verbessern
    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return ResponseEntity.ok((List<GroupDTO>) groupService.getAllGroups());
    }

    @PostMapping("/createGroup/")
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO dto) {
        return ResponseEntity.ok(groupService.createGroup(dto));
    }

    @GetMapping
    public ResponseEntity<GroupDTO> getGroupById(UUID id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @GetMapping
    public ResponseEntity<GroupDTO> getGroupByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(groupService.getGroupByName(name));
    }
//  todo
//    @PutMapping
//    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO dto) {
//        return ResponseEntity.ok(groupService.updateGroup(@PathVariable UUID ,
//                @RequestBody @Valid GroupDTO dto));
//    }

    @DeleteMapping("/deleteGroup")
    public ResponseEntity<GroupDTO> deleteGroup(@RequestParam("id") UUID id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

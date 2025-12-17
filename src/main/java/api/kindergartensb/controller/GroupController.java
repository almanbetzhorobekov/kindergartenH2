package api.kindergartensb.controller;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.service.GroupReadService;
import api.kindergartensb.service.GroupWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupReadService readService;
    private final GroupWriteService writeService;

    // GET /api/groups/{id}
    @GetMapping("/{uuid}")
    public ResponseEntity<GroupDTO> getById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(readService.getById(uuid));
    }

    // GET /api/groups
    @GetMapping
    public List<GroupDTO> getAll() {
        return readService.getAll();
    }

    @GetMapping("/by-kindergarten/{kindergartenId}")
    public List<GroupDTO> getGroupsByKindergartenId(@PathVariable UUID kindergartenId) {
        return readService.getGroupsByKindergartenId(kindergartenId);
    }
    
    // POST /api/groups
    @PostMapping
    public ResponseEntity<GroupDTO> create(@RequestBody GroupDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(writeService.create(dto));
    }

    // PUT /api/groups/{id}
    @PutMapping("/{uuid}")
    public GroupDTO update(@PathVariable UUID uuid, @RequestBody GroupDTO dto) {
        return writeService.update(uuid, dto);
    }

    // DELETE /api/groups/{id}
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        writeService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
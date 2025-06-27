package api.kindergartensb.controller;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.service.GroupReadService;
import api.kindergartensb.service.GroupWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupReadService readService;
    private final GroupWriteService writeService;

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(readService.getById(id));
    }

    @GetMapping
    public List<GroupDTO> getAll() {
        return readService.getAll();
    }

    @PostMapping
    public ResponseEntity<GroupDTO> create(@RequestBody GroupDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(writeService.create(dto));
    }

    @PutMapping("/{id}")
    public GroupDTO update(@PathVariable UUID id, @RequestBody GroupDTO dto) {
        return writeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        writeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
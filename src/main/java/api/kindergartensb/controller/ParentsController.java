package api.kindergartensb.controller;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.service.ParentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentsController {

    private final ParentsService parentsService;

    @PostMapping
    public ResponseEntity<Void> createParent(@RequestBody ParentsDTO dto) {
        parentsService.createParent(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Void> getAllParents() {
        parentsService.getAllParents();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getParentById(@PathVariable UUID id) {
        parentsService.getParentById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParent(@PathVariable UUID id, @RequestBody ParentsDTO dto) {
        parentsService.updateParent(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable UUID id) {
        parentsService.deleteParent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/add-child")
    public ResponseEntity<Void> addChild(@RequestBody api.kindergartensb.dto.ChildDTO childDTO) {
        parentsService.addChild(childDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/remove-child")
    public ResponseEntity<Void> removeChild(@RequestBody api.kindergartensb.dto.ChildDTO childDTO) {
        parentsService.removeChild(childDTO);
        return ResponseEntity.ok().build();
    }
}

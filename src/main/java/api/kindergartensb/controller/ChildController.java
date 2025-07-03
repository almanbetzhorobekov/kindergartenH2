package api.kindergartensb.controller;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.service.ChildReadService;
import api.kindergartensb.service.ChildWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildReadService childReadService;
    private final ChildWriteService childWriteService;

    @GetMapping("/{id}")
    public ResponseEntity<ChildDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(childReadService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ChildDTO>> getAll() {
        return ResponseEntity.ok(childReadService.getAllChildren());
    }

    @GetMapping("/by-parent/{parentId}")
    public ResponseEntity<List<ChildDTO>> getChildrenByParent(@PathVariable UUID parentId) {
        return ResponseEntity.ok(childReadService.getChildrenByParentId(parentId));
    }

    @GetMapping("/getParents")
    public ResponseEntity<List<ParentsDTO>> getParents() {
        return ResponseEntity.ok(childReadService.getParents());
    }

    @PostMapping("/createChild")
    public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(childWriteService.create(dto));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChildDTO> updateChild(@PathVariable UUID id, @RequestBody ChildDTO dto) {
        return ResponseEntity.ok(childWriteService.updateChild(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        childWriteService.deleteChild(id);
        return ResponseEntity.noContent().build(); // 204
    }

}

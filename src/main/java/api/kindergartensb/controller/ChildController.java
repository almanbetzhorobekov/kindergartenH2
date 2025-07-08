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
import java.util.Map;
import java.util.UUID;
/**
 * REST controller for managing children.
 */
@RestController
@RequestMapping("/api/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildReadService childReadService;
    private final ChildWriteService childWriteService;

    /**
     * Returns a child by ID.
     *
     * @param id the UUID of the child
     * @return the child data
     */
    @GetMapping("/{id}")
    public ResponseEntity<ChildDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(childReadService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChildDTO>> getAll() {
        return ResponseEntity.ok(childReadService.getAllChildren());
    }

    @GetMapping("/by-parent/{parentId}")
    public ResponseEntity<List<ChildDTO>> getChildrenByParent(@PathVariable UUID parentId) {
        return ResponseEntity.ok(childReadService.getChildrenByParentId(parentId));
    }

    @GetMapping("/parents-by-child/{id}")
    public ResponseEntity<?> getParentsByChildId(@PathVariable UUID id) {
        if (!childReadService.isExist(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Child not found by id " + id));
        }
        List<ParentsDTO> parents = childReadService.getParents(id);
        if (parents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Parent not found by child id " + id));
        }
        return ResponseEntity.ok(parents);
    }

    @PostMapping
    public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(childWriteService.create(dto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ChildDTO> updateChild(@PathVariable UUID id, @RequestBody ChildDTO dto) {
        return ResponseEntity.ok(childWriteService.updateChild(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        childWriteService.deleteChild(id);
        return ResponseEntity.noContent().build(); // 204
    }

}

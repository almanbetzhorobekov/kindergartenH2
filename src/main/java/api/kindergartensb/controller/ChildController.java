package api.kindergartensb.controller;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.service.ChildReadService;
import api.kindergartensb.service.ChildWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
     * @param uuid the UUID of the child
     * @return the child data
     */
    @GetMapping("/{uuid}")
    public ResponseEntity<ChildDTO> getById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(childReadService.getById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<ChildDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(childReadService.getAllChildren(pageable));
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<ChildDTO>> getAllInactive() {
        return ResponseEntity.ok(childReadService.getAllInactive());
    }

    @GetMapping("/by-parent/{parentId}")
    public ResponseEntity<List<ChildDTO>> getChildrenByParent(@PathVariable UUID parentId) {
        return ResponseEntity.ok(childReadService.getChildrenByParentId(parentId));
    }

    @GetMapping("/parents-by-child/{uuid}")
    public ResponseEntity<?> getParentsByChildId(@PathVariable UUID uuid) {
        if (!childReadService.isExist(uuid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Child not found by id " + uuid));
        }
        List<ParentsDTO> parents = childReadService.getParents(uuid);
        if (parents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Parent not found by child id " + uuid));
        }
        return ResponseEntity.ok(parents);
    }

    // 201
    @PostMapping
    public void createChild(@RequestBody ChildDTO dto) {
        childWriteService.create(dto);
         ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{uuid}/change-group/{groupId}")
    public ResponseEntity<ChildDTO> changeGroup(
            @PathVariable("uuid") UUID childId,
            @PathVariable("groupId") UUID newGroupID
    ) {
        ChildDTO updateChild = childWriteService.changeGroup(childId, newGroupID);
        return ResponseEntity.ok(updateChild);
    }

    @PutMapping("/{uuid}/deactivate")
    public ResponseEntity<Void> deactivateChild(@PathVariable UUID uuid) {
        childWriteService.deactivateChild(uuid);
        return ResponseEntity.noContent().build(); // 204
    }

    // NO CONTENT 204
    @PutMapping("/{uuid}")
    public ResponseEntity<ChildDTO> updateChild(
            @PathVariable UUID uuid,
            @RequestBody ChildDTO dto) {
        return ResponseEntity.ok(childWriteService.updateChild(uuid, dto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        childWriteService.deleteChild(uuid);
        return ResponseEntity.noContent().build(); // 204
    }

}

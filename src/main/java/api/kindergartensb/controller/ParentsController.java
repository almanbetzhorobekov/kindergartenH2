package api.kindergartensb.controller;
import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.service.ParentsReadService;
import api.kindergartensb.service.ParentsWriteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parents")
public class ParentsController {

    private final ParentsReadService parentsReadService;
    private final ParentsWriteService parentsWriteService;

    public ParentsController(ParentsReadService parentsReadService, ParentsWriteService parentsWriteService) {
        this.parentsReadService = parentsReadService;
        this.parentsWriteService = parentsWriteService;
    }

    @GetMapping("/children")
    public List<ChildDTO> getAllChildren(){
        return null;
    }

    @GetMapping()
    public ResponseEntity<Page<ParentsDTO>> getAll(Pageable pageable) {

        return ResponseEntity.ok(parentsReadService.getAllParents(pageable));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ParentsDTO> getParentById(@PathVariable UUID uuid) {
        ParentsDTO parent = parentsReadService.getParentsById(uuid);
        return ResponseEntity.ok(parent);
    }

    /*@GetMapping("/child/{childId}")
    public ResponseEntity<List<ParentsDTO>> getParentsByChildId(@PathVariable UUID childId) {
        List<ParentsDTO> parents = parentsReadService.getParentsByChildId(childId);
        return ResponseEntity.ok(parents);
    }
*/
    @GetMapping("/address/{uuid}")
    public ResponseEntity<AddressDTO> getAddressByParentId(@PathVariable UUID uuid) {
        AddressDTO address = parentsReadService.getAddressByParentId(uuid);
        return ResponseEntity.ok(address);
    }

    @PostMapping
    public ResponseEntity<ParentsDTO> create(@RequestBody ParentsDTO parentsDTO) {
        ParentsDTO created = parentsWriteService.create(parentsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ParentsDTO> update(@PathVariable UUID uuid, @RequestBody ParentsDTO parentsDTO) {
        ParentsDTO updated = parentsWriteService.update(uuid, parentsDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        parentsWriteService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}

package api.kindergartensb.controller;
import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.service.ParentsReadService;
import api.kindergartensb.service.ParentsWriteService;
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

    @GetMapping("/{id}")
    public ResponseEntity<ParentsDTO> getParentById(@PathVariable UUID id) {
        ParentsDTO parent = parentsReadService.getParentsById(id);
        return ResponseEntity.ok(parent);
    }

    /*@GetMapping("/child/{childId}")
    public ResponseEntity<List<ParentsDTO>> getParentsByChildId(@PathVariable UUID childId) {
        List<ParentsDTO> parents = parentsReadService.getParentsByChildId(childId);
        return ResponseEntity.ok(parents);
    }
*/
    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO> getAddressByParentId(@PathVariable UUID id) {
        AddressDTO address = parentsReadService.getAddressByParentId(id);
        return ResponseEntity.ok(address);
    }

    @PostMapping
    public ResponseEntity<ParentsDTO> create(@RequestBody ParentsDTO parentsDTO) {
        ParentsDTO created = parentsWriteService.create(parentsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentsDTO> update(@PathVariable UUID id, @RequestBody ParentsDTO parentsDTO) {
        ParentsDTO updated = parentsWriteService.update(id, parentsDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        parentsWriteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

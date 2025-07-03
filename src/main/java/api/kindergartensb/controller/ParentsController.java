package api.kindergartensb.controller;
import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.service.ParentsReadService;
import api.kindergartensb.service.ParentsWriteService;
import api.kindergartensb.service.ServiceIml.ParentsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ParentsDTO> getParentById(@PathVariable UUID id) {
        ParentsDTO parent = parentsReadService.getParentsById(id);
        return ResponseEntity.ok(parent);
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<AddressDTO> getAddressByParentId(@PathVariable UUID id) {
        AddressDTO address = parentsReadService.getAddressByParentId(id);
        return ResponseEntity.ok(address);
    }

    @PostMapping("/create")
    public ResponseEntity<ParentsDTO> createParent(@RequestBody ParentsDTO parentsDTO) {
        ParentsDTO created = parentsWriteService.create(parentsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentsDTO> updateParent(@PathVariable UUID id, @RequestBody ParentsDTO parentsDTO) {
        ParentsDTO updated = parentsWriteService.update(id, parentsDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable UUID id) {
        parentsWriteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package api.kindergartensb.controller;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;


import api.kindergartensb.service.KindergartenReadService;
import api.kindergartensb.service.KindergartenWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kindergartens")
@RequiredArgsConstructor
public class KindergartenController {

    private final KindergartenReadService readService;
    private final KindergartenWriteService writeService;

    @GetMapping("/{id}")
    public ResponseEntity<KindergartenDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(readService.getById(id));
    }

    @GetMapping
    public List<KindergartenDTO> getAllKindergartens() {
        return readService.getAll();
    }


    @PostMapping
    public ResponseEntity<KindergartenDTO> create(@RequestBody KindergartenDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(writeService.create(dto));
    }

    @PutMapping("/{id}")
    public KindergartenDTO update(@PathVariable UUID id, @RequestBody KindergartenDTO dto) {
        return writeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        writeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
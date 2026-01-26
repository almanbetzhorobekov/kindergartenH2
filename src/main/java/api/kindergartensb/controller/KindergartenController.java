package api.kindergartensb.controller;
import api.kindergartensb.dto.KindergartenDTO;

import api.kindergartensb.dto.KindergartenMiniDto;
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

    @GetMapping("/{uuid}")
    public ResponseEntity<KindergartenDTO> getById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(readService.getById(uuid));
    }

    @GetMapping
    public List<KindergartenDTO> getAllKindergartens() {
        return readService.getAll();
    }

    @GetMapping("/mini")
    public List<KindergartenMiniDto> getAllMiniInfo() {
        return readService.getAllMiniDto();
    }

    @PostMapping
    public ResponseEntity<KindergartenDTO> create(@RequestBody KindergartenDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(writeService.create(dto));
    }

    @PutMapping("/{uuid}")
    public KindergartenDTO update(@PathVariable UUID uuid, @RequestBody KindergartenDTO dto) {
        return writeService.update(uuid, dto);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        writeService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
package api.kindergartensb.controller;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.service.KindergartenService;


import api.kindergartensb.service.KindergartenGetter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kindergarten")
public class KindergartenController {

    private final KindergartenService service;
    private final KindergartenGetter getter;

    public KindergartenController(KindergartenService service
                                    ,KindergartenGetter getter) {
        this.service = service;
        this.getter = getter;
    }

    @PostMapping
    public ResponseEntity<KindergartenDTO> create(@RequestBody KindergartenDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creat(dto));
    }

    @PutMapping("/update-name")
    public ResponseEntity<KindergartenDTO> updateName(@RequestBody String newName) {
        return ResponseEntity.ok(service.updateName(newName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KindergartenDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getter.getById(id));
    }

    @GetMapping("/one")
    public ResponseEntity<KindergartenDTO> getOne() {
        return ResponseEntity.ok(getter.getOne());
    }

    @GetMapping
    public ResponseEntity<List<KindergartenDTO>> getAll() {
        return ResponseEntity.ok(getter.getAll());
    }

}
package api.kindergartensb.controller;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.service.EducatorReadService;
import api.kindergartensb.service.EducatorWriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/educators")
public class EducatorController {

    private final EducatorReadService educatorReadService;
    private final EducatorWriteService educatorWriteService;

    public EducatorController(EducatorReadService educatorReadService, EducatorWriteService educatorWriteService) {
        this.educatorReadService = educatorReadService;
        this.educatorWriteService = educatorWriteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducatorDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(educatorReadService.getEducatorById(id));
    }


}


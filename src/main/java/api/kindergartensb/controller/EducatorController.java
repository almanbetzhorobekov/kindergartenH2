package api.kindergartensb.controller;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.service.EducatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

    @RestController
    @RequestMapping("/educators")
    public class EducatorController {

        private final EducatorService educatorService;

        public EducatorController(EducatorService educatorService) {
            this.educatorService = educatorService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<EducatorDTO> getEducator(@PathVariable UUID id) {
            return ResponseEntity.ok(educatorService.getEducatorById(id));
        }

        @PostMapping
        public ResponseEntity<Void> saveEducator(@RequestBody EducatorDTO educatorDTO) {
            educatorService.saveEducator(educatorDTO);
            return ResponseEntity.ok().build();
        }

        @PutMapping("/{educatorId}/groups/{groupId}")
        public ResponseEntity<Void> assignGroup(@PathVariable UUID educatorId, @PathVariable UUID groupId) {
            educatorService.assignGroupToEducator(educatorId, groupId);
            return ResponseEntity.ok().build();
        }
    }


package api.kindergartensb.controller;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.EducatorMiniDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.service.EducatorReadService;
import api.kindergartensb.service.EducatorWriteService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Data
@RestController
@RequestMapping("/api/educators")
public class EducatorController {

    private final EducatorReadService educatorReadService;
    private final EducatorWriteService educatorWriteService;

    public EducatorController(EducatorReadService educatorReadService, EducatorWriteService educatorWriteService) {
        this.educatorReadService = educatorReadService;
        this.educatorWriteService = educatorWriteService;
    }
    @GetMapping
    public List<EducatorDTO> getAll() {
        return educatorReadService.getAll();
    }

    @GetMapping("/miniInfo")
    public ResponseEntity<Page<EducatorMiniDTO>> getMiniInfo(Pageable pageable){
        return ResponseEntity.ok(educatorReadService.getInfo(pageable));
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<EducatorDTO> getById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(educatorReadService.getEducatorById(uuid));
    }

    @PostMapping
    public ResponseEntity<EducatorDTO> create(@RequestBody EducatorDTO educatorDTO) {
        return ResponseEntity.ok(educatorWriteService.create(educatorDTO));
    } //status code 200(ok)


    @GetMapping("/groups/{uuid}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable UUID uuid) {
        return educatorReadService.getGroupById(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/groups")
    public ResponseEntity<List<GroupDTO>> getGroups() {
        List<GroupDTO> groups = educatorReadService.getGroups();

        if (groups.isEmpty()) {
            return ResponseEntity.noContent().build();//204
        } else {
            return ResponseEntity.ok(groups); //200
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@RequestBody UUID uuid) {
        educatorWriteService.delete(uuid);
        return ResponseEntity.noContent().build();//204
    }

}


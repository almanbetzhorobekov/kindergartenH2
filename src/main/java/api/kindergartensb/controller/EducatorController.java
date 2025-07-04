package api.kindergartensb.controller;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.service.EducatorReadService;
import api.kindergartensb.service.EducatorWriteService;
import lombok.Data;
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

    @GetMapping("/{id}")
    public ResponseEntity<EducatorDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(educatorReadService.getEducatorById(id));
    }

    @PostMapping
    public ResponseEntity<EducatorDTO> create(@RequestBody EducatorDTO educatorDTO) {
        return ResponseEntity.ok(educatorWriteService.create(educatorDTO));
    } //status code 200(ok)

//    @PostMapping
//    public ResponseEntity<EducatorDTO> create(@RequestBody EducatorDTO educatorDTO) {
//       EducatorDTO created = educatorWriteService.create(educatorDTO);
//    return ResponseEntity
//            .created(URI.create("/educators/" + created.getUuid()))
//            .body(created); // статус 201 Created
//    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable UUID id) {
        return educatorReadService.getGroupById(id)
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody UUID id) {
        educatorWriteService.delete(id);
        return ResponseEntity.noContent().build();//204
    }

}


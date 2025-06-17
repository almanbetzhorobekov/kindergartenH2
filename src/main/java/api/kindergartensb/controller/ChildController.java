package api.kindergartensb.controller;


import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

//    @PostMapping
//    public ChildDTO createChild(@RequestBody ChildDTO childDTO) {
//        return childService.createChild(childDTO);
//    }

    @PostMapping
    public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO childDTO) {
        try {
            ChildDTO createdChild = childService.createChild(childDTO);
            return new ResponseEntity<>(createdChild, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

    }

//    @GetMapping
//    public ResponseEntity<List<ChildDTO>> getAllChildren() {
//        List<ChildDTO> children = childService.getAllChildren();
//        return ResponseEntity.ok(children);
//    }
//
//
    @GetMapping
    public ResponseEntity<List<ChildDTO>> getAllChildren() {
        List<ChildDTO> children = childService.getAllChildren();
        return ResponseEntity.ok(children);
    }

    @GetMapping("/group/{groupName}")
    public ResponseEntity<List<ChildDTO>> getChildrenByGroupName(@PathVariable String groupName) {
        List<ChildDTO> children = childService.getChildrenByGroupName(groupName);
        if (children.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(children);
    }

//    @GetMapping("/group")
//    public List<ChildDTO> getChildrenByGroupName(@RequestParam String name) {
//        return childService.getChildrenByGroupName(name);
//    }

    @GetMapping("/educator/{educatorId}")
    public ResponseEntity<List<ChildDTO>> getChildrenByEducatorId(@PathVariable UUID educatorId) {
        List<ChildDTO> children = childService.getChildrenByEducatorId(educatorId);
        if (children.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(children);
    }

//    @GetMapping("/educator/{educatorId}")
//    public List<ChildDTO> getChildrenByEducatorId(@PathVariable UUID educatorId) {
//        return childService.getChildrenByEducatorId(educatorId);
//    }

    @GetMapping("/age-range")
    public ResponseEntity<List<ChildDTO>> getChildrenByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {
        List<ChildDTO> children = childService.getChildrenByAgeRange(min, max);
        if (children.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(children);
    }

//    @GetMapping("/age")
//    public List<ChildDTO> getChildrenByAgeRange(@RequestParam int min, @RequestParam int max) {
//        return childService.getChildrenByAgeRange(min, max);
//    }

    @GetMapping("/kindergarten/{kindergartenName}")
    public ResponseEntity<List<ChildDTO>> getChildrenByKindergarten(@PathVariable String kindergartenName) {
        List<ChildDTO> children = childService.getChildrenByKindergarten(kindergartenName);
        if (children.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(children);
    }

//    @GetMapping("/kindergarten")
//    public List<ChildDTO> getChildrenByKindergarten(@RequestParam String name) {
//        return childService.getChildrenByKindergarten(name);
//    }


}

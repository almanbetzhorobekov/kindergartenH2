package api.kindergartensb.controller;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    @GetMapping("/child/{id}")
    public ChildDTO getChild(@PathVariable UUID id) {
        Child child = childService.getChild(id);

    }

    @PutMapping("/create/{id}")
    public ChildDTO createChild(@PathVariable UUID id) {
        Child child = childService.createChild();

    }

}

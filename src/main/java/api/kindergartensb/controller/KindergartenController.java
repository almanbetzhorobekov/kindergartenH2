package api.kindergartensb.controller;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.service.KindergartenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KindergartenController {

    private final KindergartenService kindergartenService;

    @DeleteMapping("/kindergarten/{delete}")
    public KindergartenDTO removeKindergarten(@PathVariable String name) {
        Kindergarten kindergarten = kindergartenService.;
    }

}

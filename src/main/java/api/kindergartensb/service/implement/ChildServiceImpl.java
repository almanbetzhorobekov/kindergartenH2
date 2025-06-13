package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.service.ChildService;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl implements ChildService {


    private void validateAge(int age) {
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6.");
        }
    }
}


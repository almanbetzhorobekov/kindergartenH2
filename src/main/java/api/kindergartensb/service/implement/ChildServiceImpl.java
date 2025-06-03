package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.assembler.ChildAssembler;
import api.kindergartensb.service.ChildService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public ChildDTO save(ChildDTO childDTO) {
        return createChild(childDTO);
    }

    @Override
    public List<ChildDTO> getAllChild() {
        return childRepository.findAll()
                .stream()
                .map(ChildAssembler::toDto)
                .toList();
    }

    public ChildDTO createChild(ChildDTO childDTO) {
        validateAge(childDTO.getAge());

        Child child = ChildAssembler.toEntity(childDTO, null, null);
        childRepository.save(child);
        return ChildAssembler.toDto(child);
    }

    private void validateAge(int age) {
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6.");
        }
    }
}


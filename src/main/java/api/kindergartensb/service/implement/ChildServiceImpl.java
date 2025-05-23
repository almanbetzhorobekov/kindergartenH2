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
    private final ChildAssembler childAssembler;

    public ChildServiceImpl(ChildRepository childRepository, ChildAssembler childAssembler) {
        this.childRepository = childRepository;
        this.childAssembler = childAssembler;
    }

    public ChildDTO save(ChildDTO childDTO) {
        return null;
    }

    @Override
    public List<ChildDTO> getAllChild() {
        return List.of();
    }

    public ChildDTO createChild(ChildDTO childDTO) {

        validateAge(childDTO.getAge());

        Child child = childAssembler.toEntity(childDTO);
        childRepository.save(child);
        return childAssembler.mapEntityToDto(child);
    }

    private void validateAge(int age) {
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6.");
        }
    }

}

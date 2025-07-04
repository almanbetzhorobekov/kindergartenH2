package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.service.ChildReadService;
import api.kindergartensb.service.ChildWriteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class ChildServiceImpl implements ChildReadService, ChildWriteService {

    private final ChildRepository childRepository;
    private final ChildMapper childMapper;
    private final ParentsMapper parentsMapper;

    public ChildServiceImpl(ChildRepository childRepository, ChildMapper childMapper, ParentsMapper parentsMapper) {
        this.childRepository = childRepository;
        this.childMapper = childMapper;
        this.parentsMapper = parentsMapper;
    }

    @Override
    public ChildDTO getById(UUID id) {
        return childRepository.findById(id)
                .map(childMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("Child not found with id: " + id));
    }

    @Override
    public List<ChildDTO> getAllChildren() {
        return childRepository.findAll().stream()
                .map(childMapper::toDto)
                .collect(Collectors.toList());
    }

    //TODO ändern
    @Override
    public List<ParentsDTO> getParents(UUID id){
        return childRepository.findById(id)
                .map(value -> value.getParents()
                        .stream()
                        .map(parentsMapper::toDto)
                        .collect(Collectors.toList()))
                .orElseGet(List::of);
    }


    @Override
    public List<ChildDTO> getChildrenByParentId(UUID parentId) {
        return childRepository.findByParentsUuid(parentId).stream()
                .map(childMapper::toDto)
                .toList();
    }

    @Override
    public ChildDTO create(ChildDTO childDTO) {
        int age = childDTO.getAge();
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6");
        }
        Child entity = childMapper.toEntity(childDTO);
        Child saved = childRepository.save(entity);
        return childMapper.toDto(saved);
    }

    @Override
    public void deleteChild(UUID id) {
        if (!childRepository.existsById(id)) {
            throw new NoSuchElementException("Child not found with id: " + id);
        }
        childRepository.deleteById(id);
    }

    @Override
    public ChildDTO updateChild(UUID id, ChildDTO dto) {
        int age = dto.getAge();
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6");
        }
        Child existing = childRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Child not found with id: " + id));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setBirthday(dto.getBirthday());

        return childMapper.toDto(childRepository.save(existing));
    }

    @Override
    public boolean isExist(UUID id) {
        return childRepository.existsById(id);
    }

}

package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.service.ChildReadService;
import api.kindergartensb.service.ChildWriteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildReadService, ChildWriteService {

    private final ChildRepository childRepository;
    private final ChildMapper childMapper;

    public ChildServiceImpl(ChildRepository childRepository, ChildMapper childMapper) {
        this.childRepository = childRepository;
        this.childMapper = childMapper;
    }

    @Override
    public ChildDTO getById(UUID id) {
        return childRepository.findById(id)
                .map(childMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("Child not found with id: " + id));
    }
    //TODO
    @Override
    public List<ChildDTO> getAllChildren() {
        return childRepository.findAll().stream()
                .map(childMapper::toDto)
                .collect(Collectors.toList());
    }
    //TODO
    @Override
    public List<ParentsDTO> getParents() {
        return childRepository.findAll().stream()
                .flatMap(child -> child.getParents().stream())
                .distinct()
                .map(parents -> ParentsDTO.builder()
                        .uuid(parents.getUuid())
                        .firstName(parents.getFirstName())
                        .lastName(parents.getLastName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ChildDTO> getChildrenByParentId(UUID parentId) {
        return childRepository.findByParentsUuid(parentId).stream()
                .map(childMapper::toDto)
                .toList();
    }

    @Override
    public ChildDTO create(ChildDTO childDTO) {
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

    public ChildDTO updateChild(UUID id, ChildDTO dto) {
        Child existing = childRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Child not found with id: " + id));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setBirthday(dto.getBirthday());

        return childMapper.toDto(childRepository.save(existing));
    }

}

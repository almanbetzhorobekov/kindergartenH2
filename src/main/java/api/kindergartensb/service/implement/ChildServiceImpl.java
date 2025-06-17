package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.service.ChildService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;
    private final ChildMapper childMapper;


    public ChildServiceImpl(ChildRepository childRepository, ChildMapper childMapper) {
        this.childRepository = childRepository;
        this.childMapper = childMapper;
    }

    private void validateAge(int age) {
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6.");
        }
    }

    @Override
    public ChildDTO createChild(ChildDTO childDTO) {
        validateAge(childDTO.getAge());
        Child child = childMapper.toEntity(childDTO);
        childRepository.save(child);
        return childMapper.toDTO(child);
    }

    @Override
    public List<ChildDTO> saveChildren(List<ChildDTO> children) {
//        List<Child> childEntities = children.stream()
//                .map(childMapper::toEntity)
//                .toList();

        return List.of();
    }

    @Override
    public List<ChildDTO> getAllChildren() {
        return childRepository.findAll().stream()
                .map(childMapper::toDTO)
                .toList();
    }

    @Override
    public List<ChildDTO> getChildrenByGroupName(String groupName) {
        List<Child> children = childRepository.findByGroupName(groupName);
        return children.stream()
                .map(childMapper::toDTO)
                .toList();
    }

    @Override
    public List<ChildDTO> getChildrenByEducatorId(UUID educatorId) {
        List<Child> children = childRepository.findByGroup_Educator_Uuid(educatorId);
        return children.stream()
                .map(childMapper::toDTO)
                .toList();
    }

    @Override
    public List<ChildDTO> getChildrenByAgeRange(int min, int max) {
        return childRepository.findByAgeBetween(min, max)
                .stream()
                .map(childMapper::toDTO)
                .toList();
    }

    @Override
    public List<ChildDTO> getChildrenByKindergarten(String kindergartenName) {
        List<Child> children = childRepository.findByGroup_Kindergarten_Name(kindergartenName);
        return children.stream()
                .map(childMapper::toDTO)
                .toList();
    }

}


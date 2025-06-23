package api.kindergartensb.service.implement;
import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Parents;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.repository.ParentsRepository;
import api.kindergartensb.service.ParentsService;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Data
@Service
public class ParentsServiceImpl implements ParentsService {

    private final ParentsRepository parentRepository;
    private final ChildRepository childRepository;
    private final ParentsMapper parentsMapper;

    public ParentsServiceImpl(ParentsRepository parentRepository, ChildRepository childRepository, ParentsMapper parentsMapper) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.parentsMapper = parentsMapper;
    }


    @Override
    public ParentsDTO createParent(ParentsDTO dto) {
        Parents parent = parentsMapper.toEntity(dto);
        parentRepository.save(parent);
        return parentsMapper.toDTO(parent);
    }

    @Override
    public List<ParentsDTO> getAllParents() {
        return parentRepository.findAll().stream()
                .map(parentsMapper::toDTO)
                .toList();

    }

    @Override
    public ParentsDTO getParentById(UUID id) {
        Parents parent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        return parentsMapper.toDTO(parent);
    }

    @Override
    public void updateParent(UUID id, ParentsDTO dto) {

    }

    @Override
    public ParentsDTO deleteParent(UUID id) {
        Parents parent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        parentRepository.delete(parent);
        return parentsMapper.toDTO(parent);
    }

    @Override
    public void addChild(ChildDTO childDTO) {

    }

    @Override
    public void removeChild(ChildDTO childDTO) {
        UUID childId = childDTO.getId();
        childRepository.deleteById(childId);
    }

    @Override
    public void childName(ChildDTO childDTO) {
        String fullName = childDTO.getFirstName() + " " + childDTO.getLastName();
        System.out.println("Child's full name: " + fullName);
    }
}

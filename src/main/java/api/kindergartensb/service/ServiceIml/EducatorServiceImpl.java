package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.mapper.EducatorMapper;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.EducatorRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.EducatorReadService;
import api.kindergartensb.service.EducatorWriteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EducatorServiceImpl implements EducatorWriteService, EducatorReadService {

    private final EducatorRepository educatorRepository;
    private final EducatorMapper educatorMapper;
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;


    public EducatorServiceImpl(EducatorRepository educatorRepository,
                               EducatorMapper educatorMapper,
                               GroupRepository groupRepository,
                               GroupMapper groupMapper) {
        this.educatorRepository = educatorRepository;
        this.educatorMapper = educatorMapper;
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;

    }

    @Override
    public EducatorDTO getEducatorById(UUID id) {
        return educatorRepository.findById(id)
                .map(educatorMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("No educator found with id: " + id));
    }

    @Override
    public Optional<GroupDTO> getGroupById(UUID id) {
        return groupRepository.findById(id)
                .map(groupMapper::toDto);
    }

    @Override
    public List<GroupDTO> getGroups() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }
//todo
    @Override
    public AddressDTO getAddress() {
        return null;
    }

    @Override
    public EducatorDTO create(EducatorDTO educatorDTO) {
        Educator saved  = educatorRepository.save(educatorMapper
                .toEntity(educatorDTO));
        return educatorMapper.toDto(saved);
    }

    @Override
    public void delete(UUID id) {
        if (educatorRepository.existsById(id)) {
            throw new NoSuchElementException("Educator not found with id " + id);
        }
        educatorRepository.deleteById(id);
    }

    @Override
    public EducatorDTO update(UUID id, EducatorDTO educatorDTO) {
        Educator existing = educatorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Educator not found with id " + id));

        existing.setFirstName(educatorDTO.getFirstName());
        existing.setLastName(educatorDTO.getLastName());
        existing.setBirthday(educatorDTO.getBirthday());

        return educatorMapper.toDto(educatorRepository.save(existing));
    }

}

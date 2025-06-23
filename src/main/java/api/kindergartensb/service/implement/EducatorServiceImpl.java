package api.kindergartensb.service.implement;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.mapper.EducatorMapper;
import api.kindergartensb.repository.EducatorRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.repository.KindergartenRepository;
import api.kindergartensb.service.EducatorService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Data
@Service
public class EducatorServiceImpl implements EducatorService {

    private final EducatorRepository educatorRepository;
    private final EducatorMapper educatorMapper;
    private final GroupRepository groupRepository;
    private final KindergartenRepository kindergartenRepository;

    public EducatorServiceImpl(
            EducatorRepository educatorRepository,
            EducatorMapper educatorMapper,
            GroupRepository groupRepository,
            KindergartenRepository kindergartenRepository) {
        this.educatorRepository = educatorRepository;
        this.educatorMapper = educatorMapper;
        this.groupRepository = groupRepository;
        this.kindergartenRepository = kindergartenRepository;
    }


    @Override
    public EducatorDTO createEducator(EducatorDTO educatorDTO) {
        Educator educator = educatorMapper.toEntity(educatorDTO);
        educatorRepository.save(educator);
        return educatorMapper.toDto(educator);
    }

    //todo
    @Override
    public void assignGroupToEducator(UUID educatorId, UUID groupId) {
        Educator educator = educatorRepository.findById(educatorId)
                .orElseThrow(() -> new RuntimeException("Educator not found"));

        Kindergarten kindergarten = kindergartenRepository.findById()
                .orElseThrow(() -> new RuntimeException("Kindergarten not found"));

        educator.setKindergarten(kindergarten); // если есть поле
        educatorRepository.save(educator);
    }
//todo
    @Override
    public void assignKindergartenToEducator(UUID educatorId, UUID kindergartenId) {
    }
//todo
    @Override
    public EducatorDTO getEducatorById(UUID educatorId) {
        return null;
    }
//todo
    @Override
    public void saveEducator(EducatorDTO educatorDTO) {
    }

    @Override
    public List<EducatorDTO> getAllEducators() {
        return educatorRepository.findAll()
                .stream()
                .map(educatorMapper::toDto)
                .toList();
    }

    @Override
    public EducatorDTO getEducatorByEducatorName(EducatorDTO educatorDTO) {
        Educator educator = educatorRepository.findByLastName(educatorDTO.getLastName())
                .set(() -> new RuntimeException("Educator not found"));
        return educatorMapper.toDto(educator);
    }

}

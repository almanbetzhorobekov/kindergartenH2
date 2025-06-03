package api.kindergartensb.service.implement;

import api.kindergartensb.assembler.EducatorAssembler;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.repository.EducatorRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.repository.KindergartenRepository;
import api.kindergartensb.service.EducatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class EducatorServiceImpl implements EducatorService {

    private final EducatorAssembler educatorAssembler;

    private final EducatorRepository educatorRepository;
    private final GroupRepository groupRepository;
    private final KindergartenRepository kindergartenRepository;

    public EducatorServiceImpl(EducatorAssembler educatorAssembler, EducatorRepository educatorRepository,
                               GroupRepository groupRepository,
                               KindergartenRepository kindergartenRepository) {
        this.educatorAssembler = educatorAssembler;
        this.educatorRepository = educatorRepository;
        this.groupRepository = groupRepository;
        this.kindergartenRepository = kindergartenRepository;
    }

    @Override
    public void assignGroupToEducator(UUID educatorId, UUID groupId) {
        Educator educator = educatorRepository.findById(educatorId).orElseThrow();
        Group group = groupRepository.findById(groupId).orElseThrow();

        if (educator.getGroupDTOList() == null) {
            educator.setGroupDTOList(new ArrayList<>());
        }

        educator.getGroupDTOList().add(group);
        educatorRepository.save(educator);
    }

    @Override
    public void assignKindergartenToEducator(UUID educatorId, UUID kindergartenId) {
        Educator educator = educatorRepository.findById(educatorId).orElseThrow();
        Kindergarten kindergarten = kindergartenRepository.findById(kindergartenId).orElseThrow();

        educator.setKindergarten(kindergarten);
        educatorRepository.save(educator);
    }

    @Override
    public EducatorDTO getEducatorById(UUID educatorId) {
        Educator educator = educatorRepository.findById(educatorId).
                orElseThrow(() -> new RuntimeException("Educator not found"));
        return educatorAssembler.toDto(educator);
    }

    @Override
    public void saveEducator(EducatorDTO educatorDTO) {
        Educator educator = educatorAssembler.toEntity(educatorDTO);
        educatorRepository.save(educator);
    }


}

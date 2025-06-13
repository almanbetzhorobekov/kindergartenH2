package api.kindergartensb.service.implement;

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

//todo
    @Override
    public void assignGroupToEducator(UUID educatorId, UUID groupId) {

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
}

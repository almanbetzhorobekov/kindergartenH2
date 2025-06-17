package api.kindergartensb.service.implement;

import api.kindergartensb.dto.EducatorDTO;

import api.kindergartensb.service.EducatorService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class EducatorServiceImpl implements EducatorService {

    @Override
    public void createEducator(EducatorDTO educatorDTO) {
    }

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

    @Override
    public void getAllEducators() {
    }

    @Override
    public EducatorDTO getEducatorByEducatorName(EducatorDTO educatorName) {
        return null;
    }
}

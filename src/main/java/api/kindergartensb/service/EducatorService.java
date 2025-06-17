package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;
import java.util.UUID;


public interface EducatorService {

    void createEducator(EducatorDTO educatorDTO);
    void assignGroupToEducator(UUID educatorId, UUID groupId);
    void assignKindergartenToEducator(UUID educatorId, UUID kindergartenId);
    EducatorDTO getEducatorById(UUID educatorId);
    void saveEducator(EducatorDTO educatorDTO);
    void getAllEducators();
    EducatorDTO getEducatorByEducatorName(EducatorDTO educatorName);

}


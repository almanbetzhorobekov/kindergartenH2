package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;

import java.util.List;
import java.util.UUID;


public interface EducatorService {

    EducatorDTO createEducator(EducatorDTO educatorDTO);
    void assignGroupToEducator(UUID educatorId, UUID groupId);
    void assignKindergartenToEducator(UUID educatorId, UUID kindergartenId);
    EducatorDTO getEducatorById(UUID educatorId);
    void saveEducator(EducatorDTO educatorDTO);
    List<EducatorDTO> getAllEducators();
    EducatorDTO getEducatorByEducatorName(EducatorDTO educatorName);

}


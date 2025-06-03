package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public interface EducatorService {

    void assignGroupToEducator(UUID educatorId, UUID groupId);
    void assignKindergartenToEducator(UUID educatorId, UUID kindergartenId);
    EducatorDTO getEducatorById(UUID educatorId);
    void saveEducator(EducatorDTO educatorDTO);

}


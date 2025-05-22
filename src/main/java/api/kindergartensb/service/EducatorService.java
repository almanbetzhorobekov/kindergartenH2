package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;
import org.springframework.stereotype.Service;

@Service

public interface EducatorService {
    public void assignGroupToEducator(EducatorDTO educatorDTO, GroupDTO groupDTO);
    public void assignKindergartenToEducator(EducatorDTO educatorDTO, KindergartenDTO kindergartenDTO);
}

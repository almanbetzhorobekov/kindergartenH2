package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import org.springframework.stereotype.Service;

@Service

public interface EducatorService {
    public void assignGroupToEducator(Educator educator, Group group);
    public void assignKindergartenToEducator(EducatorDTO educatorDTO, KindergartenDTO kindergartenDTO);
}

package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;

import api.kindergartensb.dto.KindergartenDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KindergartenService {

    void removeEducator(List<EducatorDTO> educatorDTO);
    int totalCountChild(List<GroupDTO> groupDTOList);
    void addGroupToKindergarten(KindergartenDTO kindergartenDTO, GroupDTO groupDTO);
    void removeGroupFromKindergarten(GroupDTO groupDTO);
    void totalCountGroup(List<GroupDTO> groupDTOList);
    void assignEducatorToKindergarten(KindergartenDTO kindergartenDTO, EducatorDTO educatorDTO);


}

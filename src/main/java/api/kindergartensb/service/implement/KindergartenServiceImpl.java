package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.service.KindergartenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindergartenServiceImpl implements KindergartenService {

    @Override
    public void removeEducator(List<EducatorDTO> educatorDTO) {
        educatorDTO.clear();
    }

    @Override
    public int totalCountChild(List<GroupDTO> groupDTOList) {
        int totalChild = 0;
        for (GroupDTO groupDTO : groupDTOList) {
            totalChild += groupDTO.counterChild();
        }
        return totalChild;

    }

    @Override
    public void addGroupToKindergarten(KindergartenDTO kindergartenDTO, GroupDTO groupDTO) {
        if (kindergartenDTO.getGroupDTOS().size() < kindergartenDTO.MAX_GROUP) {
            kindergartenDTO.getGroupDTOS().add(groupDTO);
            groupDTO.setKindergartenDTO(kindergartenDTO);
        } else {
            throw new IllegalStateException("In Kindergarten there cannot be more than " + kindergartenDTO.MAX_GROUP + " groups.");
        }
    }

    @Override
    public void removeGroupFromKindergarten(GroupDTO groupDTO) {
        groupDTO.setKindergartenDTO(null);
    }

    @Override
    public void totalCountGroup(List<GroupDTO> groupDTOList) {

    }

    @Override
    public void assignEducatorToKindergarten(KindergartenDTO kindergartenDTO, EducatorDTO educatorDTO) {
        educatorDTO.setKindergartenDTO(kindergartenDTO);
        if (educatorDTO.getKindergartenDTO() == null) {
            educatorDTO.setKindergartenDTO(kindergartenDTO);
        }
        kindergartenDTO.getEducatorDTOList().add(educatorDTO);
    }

}

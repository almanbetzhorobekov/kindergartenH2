package api.kindergartensb.service;


import api.kindergartensb.dto.ChildDTO;
import java.util.List;
import java.util.UUID;

public interface ChildService {

    ChildDTO createChild(ChildDTO childDTO);
    List<ChildDTO> saveChildren(List<ChildDTO> children);
    List<ChildDTO> getAllChildren();
    List<ChildDTO> getChildrenByGroupName(String groupName);
    List<ChildDTO> getChildrenByEducatorId(UUID educatorId);
    List<ChildDTO> getChildrenByAgeRange(int min, int max);
    List<ChildDTO> getChildrenByKindergarten(String kindergartenName);

}

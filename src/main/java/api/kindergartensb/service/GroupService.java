package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import java.util.List;
import java.util.UUID;

public interface GroupService {

    GroupDTO createGroup(GroupDTO dto);
    GroupDTO getAllGroups();
    GroupDTO getGroupById(UUID id);
    GroupDTO updateGroup(UUID id, GroupDTO dto);
    GroupDTO delete(UUID id);
    List<GroupDTO> getGroupsByKindergarten(String kindergartenName);
    GroupDTO getGroupByName(String groupName);
    List<ChildDTO> getChildrenInGroup(UUID groupId);
    EducatorDTO getEducatorOfGroup(UUID groupId);

}

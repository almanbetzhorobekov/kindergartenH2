package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Data
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

//todo
    @Override
    public GroupDTO createGroup(GroupDTO dto) {
        return null;
    }
//todo
    @Override
    public GroupDTO getAllGroups() {
        return null;
    }
//todo
    @Override
    public GroupDTO getGroupById(UUID id) {
        return null;
    }
//todo
    @Override
    public GroupDTO updateGroup(UUID id, GroupDTO dto) {
        return null;
    }
//todo
    @Override
    public GroupDTO delete(UUID id) {
        return null;
    }
//todo
    @Override
    public List<GroupDTO> getGroupsByKindergarten(String kindergartenName) {
        return List.of();
    }
//todo
    @Override
    public GroupDTO getGroupByName(String groupName) {
        return null;
    }
//todo
    @Override
    public List<ChildDTO> getChildrenInGroup(UUID groupId) {
        return List.of();
    }
//todo
    @Override
    public EducatorDTO getEducatorOfGroup(UUID groupId) {
        return null;
    }
}

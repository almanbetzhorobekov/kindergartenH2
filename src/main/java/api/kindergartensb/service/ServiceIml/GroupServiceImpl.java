package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupGetter;
import api.kindergartensb.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService, GroupGetter {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public GroupDTO create(GroupDTO dto) {

        Group group = groupMapper.toEntity(dto);
        return groupMapper.toDto(groupRepository.save(group));

    }

    @Override
    public GroupDTO getById(UUID id) {
        return groupRepository.findById(id)
                .map(groupMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public List<GroupDTO> getAll() {
        return List.of();
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

}

package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper mapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper mapper) {
        this.groupRepository = groupRepository;
        this.mapper = mapper;
    }

    @Override
    public GroupDTO create(GroupDTO dto) {

        Group group = mapper.toEntity(dto);
        return mapper.toDto(groupRepository.save(group));

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

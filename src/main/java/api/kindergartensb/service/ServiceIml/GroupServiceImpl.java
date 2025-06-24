package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper mapper;

    @Override
    public GroupDTO create(GroupDTO dto) {
        Group group = mapper.toEntity(dto);
        group.setUuid(UUID.randomUUID());
        Group saved  = groupRepository.save(group);
        return mapper.toDto(saved);

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

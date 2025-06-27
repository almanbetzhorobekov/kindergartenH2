package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupReadService;
import api.kindergartensb.service.GroupWriteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupReadService, GroupWriteService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public GroupDTO getById(UUID id) {
        return groupRepository.findById(id)
                .map(groupMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));
    }

    @Override
    public List<GroupDTO> getAll() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GroupDTO create(GroupDTO dto) {
        Group saved = groupRepository.save(groupMapper.toEntity(dto));
        return groupMapper.toDto(saved);
    }

    @Override
    public GroupDTO update(UUID id, GroupDTO dto) {
        Group updated = groupMapper.toEntity(dto);
        updated.setUuid(id);
        return groupMapper.toDto(groupRepository.save(updated));
    }

    @Override
    public void delete(UUID id) {
        groupRepository.deleteById(id);
    }
}
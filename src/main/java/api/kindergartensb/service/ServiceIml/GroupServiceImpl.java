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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
/**
 * Service implementation for managing {@link Group} entities.
 * <p>
 * Provides read and write operations such as create, update, delete and fetch groups.
 * Uses {@link GroupRepository} for persistence and {@link GroupMapper} for mapping
 * between entities and DTOs.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupReadService, GroupWriteService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    /**
     * Retrieves a {@link GroupDTO} by its unique identifier.
     *
     * @param uuid the UUID of the group to retrieve
     * @return the corresponding {@link GroupDTO}
     * @throws EntityNotFoundException if no group with the specified ID exists
     */
    @Override
    public GroupDTO getById(UUID uuid) {
        return groupRepository.findById(uuid)
                .map(groupMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));
    }
    /**
     * Retrieves all groups as a list of {@link GroupDTO}.
     *
     * @return list of all groups
     */
    @Override
    @Transactional(readOnly = true)
    public List<GroupDTO> getAll() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<GroupDTO> getGroupsByKindergartenId(UUID kindergartenId) {
        return groupRepository.findByKindergartenUuid(kindergartenId)
                .stream()
                .map(groupMapper::toDto)
                .toList();
    }


    /**
     * Creates and saves a new {@link Group} entity from the provided {@link GroupDTO}.
     *
     * @param dto the data transfer object containing group details
     * @return the saved {@link GroupDTO}
     */
    @Override
    public GroupDTO create(GroupDTO dto) {
        Group saved = groupRepository.save(groupMapper.toEntity(dto));
        return groupMapper.toDto(saved);
    }

    /**
     * Updates the name of an existing group identified by the given ID.
     *
     * @param uuid  the UUID of the group to update
     * @param dto the {@link GroupDTO} containing the updated group information
     * @return the updated {@link GroupDTO}
     * @throws EntityNotFoundException if no group with the specified ID exists
     */
    @Override
    public GroupDTO update(UUID uuid, GroupDTO dto) {
        Group groupExisting = groupRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Group not found by " + uuid));

        groupExisting.setGroupName(dto.getGroupName());
        return groupMapper.toDto(groupRepository.save(groupExisting));
    }
    /**
     * Deletes a group identified by the given UUID.
     *
     * @param uuid the UUID of the group to delete
     */
    @Override
    public void delete(UUID uuid) {
        groupRepository.deleteById(uuid);
    }
}
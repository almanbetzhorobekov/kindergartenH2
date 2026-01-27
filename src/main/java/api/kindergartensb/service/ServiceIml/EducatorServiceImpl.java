package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.EducatorMiniDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.AddressMapper;
import api.kindergartensb.mapper.EducatorMapper;
import api.kindergartensb.mapper.GroupMapper;
import api.kindergartensb.repository.EducatorRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.EducatorReadService;
import api.kindergartensb.service.EducatorWriteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class EducatorServiceImpl implements EducatorWriteService, EducatorReadService {

    private final EducatorRepository educatorRepository;
    private final EducatorMapper educatorMapper;
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final AddressMapper addressMapper;


    public EducatorServiceImpl(EducatorRepository educatorRepository,
                               EducatorMapper educatorMapper,
                               GroupRepository groupRepository,
                               GroupMapper groupMapper, AddressMapper addressMapper) {
        this.educatorRepository = educatorRepository;
        this.educatorMapper = educatorMapper;
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.addressMapper = addressMapper;
    }
    /**
     * Retrieves an {@link EducatorDTO} by its unique identifier.
     *
     * @param uuid the UUID of the educator to retrieve
     * @return the corresponding {@link EducatorDTO}
     * @throws NoSuchElementException if no educator with the specified ID exists
     */
    @Override
    public EducatorDTO getEducatorById(UUID uuid) {
        return educatorRepository.findById(uuid)
                .map(educatorMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("No educator found with id: " + uuid));
    }
    /**
     * Retrieves a {@link GroupDTO} by its unique identifier, if it exists.
     *
     * @param uuid the UUID of the group to retrieve
     * @return an {@link Optional} containing the {@link GroupDTO} if found, or empty if not found
     */
    @Override
    public Optional<GroupDTO> getGroupById(UUID uuid) {
        return groupRepository.findById(uuid)
                .map(groupMapper::toDto);
    }
    /**
     * Retrieves all groups from the repository and maps them to {@link GroupDTO} objects.
     *
     * @return a list of all groups as {@link GroupDTO}
     */
    @Override
    public List<GroupDTO> getGroups() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddress() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EducatorDTO> getAll() {
        return educatorMapper.toDtoList(
                educatorRepository.findAll()
        );
    }

    @Override
    public Page<EducatorMiniDTO> getInfo(Pageable pageable) {
        return educatorRepository.findAll(pageable)
                .map(educator -> new EducatorMiniDTO(
                        educator.getUuid(),
                        educator.getFirstName(),
                        educator.getLastName(),
                        educator.getEmail(),
                        educator.getPhoneNumber(),
                        educator.getAddress() != null ? addressMapper.toDto(educator.getAddress()) : null
                ));
    }


    /**
     * Creates and saves a new {@link Educator} entity from the provided {@link EducatorDTO}.
     *
     * @param educatorDTO the {@link EducatorDTO} containing data for the new educator
     * @return the saved {@link EducatorDTO} after persistence
     */
    @Override
    public EducatorDTO create(EducatorDTO educatorDTO) {
        Educator saved  = educatorRepository.save(educatorMapper
                .toEntity(educatorDTO));
        return educatorMapper.toDto(saved);
    }
    /**
     * Deletes an {@link Educator} entity by its unique identifier.
     *
     * @param uuid the UUID of the educator to be deleted
     * @throws NoSuchElementException if no educator with the specified ID exists
     */
    @Override
    public void delete(UUID uuid) {
        if (!educatorRepository.existsById(uuid)) {
            throw new NoSuchElementException("Educator not found with id " + uuid);
        }
        educatorRepository.deleteById(uuid);
    }
    /**
     * Updates an existing {@link Educator} entity's basic information using the provided {@link EducatorDTO}.
     *
     * @param uuid the UUID of the educator to update
     * @param educatorDTO the {@link EducatorDTO} containing updated data
     * @return the updated {@link EducatorDTO} after saving
     * @throws NoSuchElementException if no educator with the specified ID exists
     */
    @Override
    public EducatorDTO update(UUID uuid, EducatorDTO educatorDTO) {
        Educator existing = educatorRepository.findById(uuid)
                .orElseThrow(() -> new NoSuchElementException("Educator not found with id " + uuid));

        existing.setFirstName(educatorDTO.getFirstName());
        existing.setLastName(educatorDTO.getLastName());
        existing.setBirthday(educatorDTO.getBirthday());

        return educatorMapper.toDto(educatorRepository.save(existing));
    }

}

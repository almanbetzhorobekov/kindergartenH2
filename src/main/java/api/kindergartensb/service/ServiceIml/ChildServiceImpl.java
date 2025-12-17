package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.ChildReadService;
import api.kindergartensb.service.ChildWriteService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
/**
 * Service for managing children in the kindergarten system.
 */
@Transactional
@Service
public class ChildServiceImpl implements ChildReadService, ChildWriteService {

    private final ChildRepository childRepository;
    private final ChildMapper childMapper;
    private final ParentsMapper parentsMapper;
    private final GroupRepository groupRepository;

    public ChildServiceImpl(ChildRepository childRepository,
                            ChildMapper childMapper,
                            ParentsMapper parentsMapper,
                            GroupRepository groupRepository) {
        this.childRepository = childRepository;
        this.childMapper = childMapper;
        this.parentsMapper = parentsMapper;
        this.groupRepository = groupRepository;
    }
    /**
     * Retrieves a {@link ChildDTO} by its unique identifier.
     *
     * @param uuid the UUID of the child to retrieve
     * @return the {@link ChildDTO} corresponding to the given ID
     * @throws NoSuchElementException if no child is found with the specified ID
     */
    @Override
    public ChildDTO getById(UUID uuid) {
        return childRepository.findById(uuid)
                .map(childMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("Child not found with id: " + uuid));
    }
    /**
     * Retrieves all children from the repository and maps them to {@link ChildDTO} objects.
     *
     * @return a list of all children represented as {@link ChildDTO}
     */
    @Override
    public Page<ChildDTO> getAllChildren(Pageable pageable) {
        return childRepository.findAllByActiveTrue(pageable)
                .map(childMapper::toDto);
    }
    /**
     * Retrieves the list of {@link ParentsDTO} associated with a child by the given child ID.
     *
     * @param id the UUID of the child whose parents are to be retrieved
     * @return a list of {@link ParentsDTO}, or an empty list if the child is not found
     */
    @Override
    public List<ParentsDTO> getParents(UUID id){
        return childRepository.findById(id)
                .map(value -> value.getParents()
                        .stream()
                        .map(parentsMapper::toDto)
                        .collect(Collectors.toList()))
                .orElseGet(List::of);
    }
    /**
     * Retrieves all {@link ChildDTO} objects that are associated with a given parent ID.
     *
     * @param parentId the UUID of the parent whose children should be retrieved
     * @return a list of {@link ChildDTO} associated with the specified parent
     */
    @Override
    public List<ChildDTO> getChildrenByParentId(UUID parentId) {
        return childRepository.findByParentsUuid(parentId).stream()
                .map(childMapper::toDto)
                .toList();
    }
    /**
     * Creates a new {@link Child} entity from the provided {@link ChildDTO} and saves it to the repository.
     * Validates that the child's age is between 1 and 6 (inclusive).
     *
     * @param childDTO the {@link ChildDTO} containing the data for the new child
     * @return the saved {@link ChildDTO} after persistence
     * @throws IllegalArgumentException if the age is not between 1 and 6
     */
    @Override
    public ChildDTO create(ChildDTO childDTO) {
        int age = childDTO.getAge();
        if (age < 1 || age > 7) {
            throw new IllegalArgumentException("Age must be between 1 and 7");
        }
        final Child built = Child.builder().uuid(UUID.randomUUID()).age(null).build();
        Child entity = childMapper.toEntity(childDTO);
        Child saved = childRepository.save(entity);
        return childMapper.toDto(saved);
    }
    /**
     * Deletes a {@link Child} entity by its unique identifier.
     *
     * @param uuid the UUID of the child to be deleted
     * @throws NoSuchElementException if no child with the specified ID exists
     */
    @Override
    public void deleteChild(UUID uuid) {
        deactivateChild(uuid);
    }
    /**
     * Updates the basic information of an existing {@link Child} entity with data from the provided {@link ChildDTO}.
     * Only first name, last name, and birthday are updated. Validates that the child's age is between 1 and 6.
     *
     * @param uuid the UUID of the child to be updated
     * @param dto the {@link ChildDTO} containing the updated data
     * @return the updated {@link ChildDTO}
     * @throws IllegalArgumentException if the age is not between 1 and 6
     * @throws NoSuchElementException if no child with the specified ID exists
     */
    @Override
    public ChildDTO updateChild(UUID uuid, ChildDTO dto) {
        if (dto.getBirthday() == null) {
            throw new IllegalArgumentException("Birthday must not be null");
        }

        int age = dto.getAge();
        if (age < 1 || age > 6) {
            throw new IllegalArgumentException("Age must be between 1 and 6");
        }
        Child existing = childRepository.findById(uuid)
                .orElseThrow(() -> new NoSuchElementException("Child not found with id: " + uuid));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setBirthday(dto.getBirthday());

        return childMapper.toDto(childRepository.save(existing));
    }

    @Override
    public void deactivateChild(UUID uuid) {
        Child child = childRepository.findById(uuid)
                .orElseThrow(() -> new NoSuchElementException("Kind nicht gefunden"));
        if (!child.isActive()) {
            throw new IllegalStateException("Kind ist bereits inaktiv");
        }

        child.setActive(false);
        childRepository.save(child);
    }

    @Override
    public ChildDTO changeGroup(UUID uuid, UUID newGroupId) {
        Child child = childRepository.findById(uuid)
                .orElseThrow(() -> new NoSuchElementException("Child not found"));

        if (!child.isActive()) {
            throw new IllegalStateException("Child is inactive and cannot change group");
        }

        Group newGroup = groupRepository.findById(newGroupId)
                .orElseThrow(() -> new NoSuchElementException("Group not found"));

        child.setGroup(newGroup);
        Child saved = childRepository.save(child);

        return childMapper.toDto(saved);
    }

    @Override
    public boolean isExist(UUID id) {
        return childRepository.existsById(id);
    }

}

package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Parents;
import api.kindergartensb.mapper.AddressMapper;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ParentsRepository;
import api.kindergartensb.service.ParentsReadService;
import api.kindergartensb.service.ParentsWriteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service implementation for managing {@link Parents} entities.
 * <p>
 * Provides CRUD operations using {@link ParentsRepository} and uses {@link ParentsMapper}
 * and {@link AddressMapper} for mapping entities to DTOs and обратно.
 * </p>
 */
@Service
public class ParentsServiceImpl implements ParentsReadService, ParentsWriteService {

    private final ParentsMapper parentsMapper;
    private final ParentsRepository parentsRepository;
    private final AddressMapper addressMapper;

    public ParentsServiceImpl(ParentsMapper parentsMapper, ParentsRepository parentsRepository, AddressMapper addressMapper) {
        this.parentsMapper = parentsMapper;
        this.parentsRepository = parentsRepository;
        this.addressMapper = addressMapper;
    }

    /**
     * Retrieves a {@link ParentsDTO} by its unique identifier.
     *
     * @param id the UUID of the parent to retrieve
     * @return the corresponding {@link ParentsDTO}
     * @throws RuntimeException if no parent with the specified ID exists
     */
    @Override
    public ParentsDTO getParentsById(UUID id) {
        return parentsRepository.findById(id)
                .map(parentsMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Parent not found by " + id));
    }
    /**
     * Retrieves the {@link AddressDTO} associated with the given parent's ID.
     *
     * @param parentId the UUID of the parent whose address should be retrieved
     * @return the corresponding {@link AddressDTO}
     * @throws RuntimeException if no parent with the specified ID exists
     */
    @Override
    public AddressDTO getAddressByParentId(UUID parentId) {
        Parents parent = parentsRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found by " + parentId));

        return addressMapper.toDto(parent.getAddress());
    }

   /**@Override
    public List<ParentsDTO> getParentsByChildId(UUID childId) {
        return parentsRepository.findAll().stream()
                .filter(parents -> parents.getChildList().stream()
                        .anyMatch(child -> getChildId));
    }
*/
    @Override
    public List<ParentsDTO> getAllParents() {
        List<Parents> parentsList = parentsRepository.findAll();
        return parentsList.stream()
                .map(parentsMapper::toDto)
                .collect(Collectors.toList());
    }


    /**
     * Creates and saves a new {@link Parents} entity from the provided {@link ParentsDTO}.
     *
     * @param parentsDTO the data transfer object containing parent details
     * @return the saved {@link ParentsDTO}
     */
    @Override
    public ParentsDTO create(ParentsDTO parentsDTO) {
        Parents savedParents = parentsRepository.save(parentsMapper
                .toEntity(parentsDTO));
        return parentsMapper.toDto(savedParents);
    }
    /**
     * Updates an existing {@link Parents} entity with the data from the provided {@link ParentsDTO}.
     *
     * @param id         the UUID of the parent to update
     * @param parentsDTO the DTO containing updated parent information
     * @return the updated {@link ParentsDTO}
     * @throws RuntimeException if no parent with the specified ID exists
     */
    @Override
    public ParentsDTO update(UUID id, ParentsDTO parentsDTO) {
        Parents existingParent = parentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found by " + id));

        existingParent.setFirstName(parentsDTO.getFirstName());
        existingParent.setLastName(parentsDTO.getLastName());
        existingParent.setBirthday(parentsDTO.getBirthday());

        return parentsMapper.toDto(parentsRepository.save(existingParent));
    }

    /**
     * Deletes a parent identified by the given UUID.
     *
     * @param id the UUID of the parent to delete
     * @throws RuntimeException if no parent with the specified ID exists
     */
    @Override
    public void delete(UUID id) {
        if (!parentsRepository.existsById(id)) {
            throw new RuntimeException("Parent not found by " + id);
        }
        parentsRepository.deleteById(id);
    }
}

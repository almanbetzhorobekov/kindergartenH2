package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.mapper.KindergartenMapper;
import api.kindergartensb.repository.KindergartenRepository;
import api.kindergartensb.service.KindergartenReadService;
import api.kindergartensb.service.KindergartenWriteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service implementation for managing {@link Kindergarten} entities.
 * <p>
 * Provides basic CRUD operations and uses {@link KindergartenRepository} for persistence
 * and {@link KindergartenMapper} for mapping between entity and DTO.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class KindergartenServiceImpl implements KindergartenReadService, KindergartenWriteService {

    private final KindergartenRepository kindergartenRepository;
    private final KindergartenMapper kindergartenMapper;
    /**
     * Retrieves a {@link KindergartenDTO} by its unique identifier.
     *
     * @param id the UUID of the kindergarten to retrieve
     * @return the corresponding {@link KindergartenDTO}
     * @throws EntityNotFoundException if no kindergarten with the specified ID exists
     */
    @Override
    public KindergartenDTO getById(UUID id) {
        return kindergartenRepository.findById(id)
                .map(kindergartenMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }
    /**
     * Retrieves all kindergartens as a list of {@link KindergartenDTO}.
     *
     * @return list of all kindergartens
     */
    @Override
    public List<KindergartenDTO> getAll() {
        return kindergartenRepository.findAll().stream()
                .map(kindergartenMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Creates and saves a new {@link Kindergarten} entity from the provided {@link KindergartenDTO}.
     *
     * @param dto the data transfer object containing kindergarten details
     * @return the saved {@link KindergartenDTO}
     */
    @Override
    public KindergartenDTO create(KindergartenDTO dto) {
        Kindergarten saved = kindergartenRepository.save(kindergartenMapper.toEntity(dto));
        return kindergartenMapper.toDto(saved);
    }
    /**
     * Deletes a kindergarten identified by the given UUID.
     *
     * @param id the UUID of the kindergarten to delete
     */
    @Override
    public void delete(UUID id) {
        kindergartenRepository.deleteById(id);
    }
    /**
     * Updates the name of an existing kindergarten identified by the given ID.
     *
     * @param id  the UUID of the kindergarten to update
     * @param dto the {@link KindergartenDTO} containing the updated kindergarten information
     * @return the updated {@link KindergartenDTO}
     * @throws NoSuchElementException if no kindergarten with the specified ID exists
     */
    @Override
    public KindergartenDTO update(UUID id, KindergartenDTO dto) {
        Kindergarten entityExisting = kindergartenRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Kindergarten not found with id: " + id));
        entityExisting.setKindergartenName(dto.getKindergartenName());
        return kindergartenMapper.toDto(kindergartenRepository.save(entityExisting));

    }
}

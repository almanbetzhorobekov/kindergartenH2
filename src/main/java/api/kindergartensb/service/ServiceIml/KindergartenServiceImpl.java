package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.dto.KindergartenMiniDto;
import api.kindergartensb.entity.Address;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.mapper.KindergartenMapper;
import api.kindergartensb.repository.KindergartenRepository;
import api.kindergartensb.service.KindergartenReadService;
import api.kindergartensb.service.KindergartenWriteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

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
     * @param uuid the UUID of the kindergarten to retrieve
     * @return the corresponding {@link KindergartenDTO}
     * @throws EntityNotFoundException if no kindergarten with the specified ID exists
     */
    @Override
    public KindergartenDTO getById(UUID uuid) {
        return kindergartenRepository.findById(uuid)
                .map(kindergartenMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }
    /**
     * Retrieves all kindergartens as a list of {@link KindergartenDTO}.
     *
     * @return list of all kindergartens
     */
    @Override
    @Transactional(readOnly = true)
    public List<KindergartenDTO> getAll() {
        return kindergartenRepository.findAll().stream()
                .map(kindergartenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<KindergartenMiniDto> getAllMiniDto() {
        List<KindergartenMiniDto> miniDtos = new ArrayList<>();
        kindergartenRepository.findAll()
                .forEach(kindergarten -> {
                    Address address = kindergarten.getAddress();
                    KindergartenMiniDto dto = new KindergartenMiniDto(
                            kindergarten.getUuid(),
                            kindergarten.getKindergartenName(),
                            address != null ? address.getPlz() : null,
                            address != null ? address.getStreet() : null,
                            address != null ? address.getHouseNumber() : null
                    );
                    miniDtos.add(dto);
                });
        return miniDtos;
    }

    @Override
    public KindergartenDTO findWithGroupsByUuid(UUID uuid) {
        Kindergarten entity = kindergartenRepository
                .findWithGroupsByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Kindergarten mit Gruppen nicht gefunden"));

        return kindergartenMapper.toDto(entity);
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
     * @param uuid the UUID of the kindergarten to delete
     */
    @Override
    public void delete(UUID uuid) {
        kindergartenRepository.deleteById(uuid);
    }
    /**
     * Updates the name of an existing kindergarten identified by the given ID.
     *
     * @param uuid  the UUID of the kindergarten to update
     * @param dto the {@link KindergartenDTO} containing the updated kindergarten information
     * @return the updated {@link KindergartenDTO}
     * @throws NoSuchElementException if no kindergarten with the specified ID exists
     */
    @Override
    public KindergartenDTO update(UUID uuid, KindergartenDTO dto) {
        Kindergarten entityExisting = kindergartenRepository.findById(uuid)
                        .orElseThrow(() -> new NoSuchElementException("Kindergarten not found with id: " + uuid));
        entityExisting.setKindergartenName(dto.getKindergartenName());
        return kindergartenMapper.toDto(kindergartenRepository.save(entityExisting));

    }
}

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


@Service
@RequiredArgsConstructor
public class KindergartenServiceImpl implements KindergartenReadService, KindergartenWriteService {

    private final KindergartenRepository kindergartenRepository;
    private final KindergartenMapper kindergartenMapper;

    @Override
    public KindergartenDTO getById(UUID id) {
        return kindergartenRepository.findById(id)
                .map(kindergartenMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public List<KindergartenDTO> getAll() {
        return kindergartenRepository.findAll().stream()
                .map(kindergartenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KindergartenDTO create(KindergartenDTO dto) {
        Kindergarten saved = kindergartenRepository.save(kindergartenMapper.toEntity(dto));
        return kindergartenMapper.toDto(saved);
    }

    @Override
    public void delete(UUID id) {
        kindergartenRepository.deleteById(id);
    }

    @Override
    public KindergartenDTO update(UUID id, KindergartenDTO dto) {
        Kindergarten entityExisting = kindergartenRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Kindergarten not found with id: " + id));
        entityExisting.setKindergartenName(dto.getKindergartenName());
        return kindergartenMapper.toDto(kindergartenRepository.save(entityExisting));

    }
}

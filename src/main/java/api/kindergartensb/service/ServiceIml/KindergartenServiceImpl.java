package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.mapper.KindergartenMapper;
import api.kindergartensb.repository.KindergartenRepository;
import api.kindergartensb.service.KindergartenGetter;
import api.kindergartensb.service.KindergartenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class KindergartenServiceImpl implements KindergartenService, KindergartenGetter {

    private final KindergartenRepository repository;
    @Qualifier("kindergartenMapper")
    private final KindergartenMapper mapper;

    @Override
    public KindergartenDTO creat(KindergartenDTO kindergartenDTO) {
        Kindergarten kindergarten = mapper.toEntity(kindergartenDTO);
        return mapper.toDto(repository.save(kindergarten));
    }

    @Override
    public KindergartenDTO getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Kindergarten not found"));
    }

    @Override
    public KindergartenDTO getOne() {
        Kindergarten kindergarten = repository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Kindergarten not found"));
        return mapper.toDto(kindergarten);
    }

    @Override
    public KindergartenDTO updateName(String newName) {
        Kindergarten kindergarten = repository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Kindergarten not found"));

        kindergarten.setKindergartenName(newName);

        Kindergarten updated = repository.save(kindergarten);

        return mapper.toDto(updated);
    }

    @Override
    public List<KindergartenDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

}



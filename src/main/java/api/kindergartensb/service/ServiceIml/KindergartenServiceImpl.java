package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import api.kindergartensb.mapper.KindergartenMapper;
import api.kindergartensb.repository.KindergartenRepository;
import api.kindergartensb.service.KindergartenGetter;
import api.kindergartensb.service.KindergartenService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KindergartenServiceImpl implements KindergartenService, KindergartenGetter {

    private final KindergartenRepository repository;
    private final KindergartenMapper kindergartenMapper;

    public KindergartenServiceImpl(KindergartenRepository repository,
                                   KindergartenMapper kindergartenMapper) {
        this.repository = repository;
        this.kindergartenMapper = kindergartenMapper;
    }

    @Override
    public KindergartenDTO creat(KindergartenDTO kindergartenDTO) {
        Kindergarten kindergarten = kindergartenMapper.toEntity(kindergartenDTO);
        return kindergartenMapper.toDto(repository.save(kindergarten));
    }

    @Override
    public KindergartenDTO getById(UUID id) {
        return repository.findById(id)
                .map(kindergartenMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Kindergarten not found"));
    }

    @Override
    public KindergartenDTO getOne() {
        Kindergarten kindergarten = repository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Kindergarten not found"));
        return kindergartenMapper.toDto(kindergarten);
    }


    @Override
    public List<KindergartenDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(kindergartenMapper::toDto)
                .toList();
    }

}



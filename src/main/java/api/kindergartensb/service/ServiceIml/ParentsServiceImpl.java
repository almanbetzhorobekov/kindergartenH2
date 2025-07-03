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

import java.util.UUID;

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

    @Override
    public ParentsDTO getParentsById(UUID id) {
        return parentsRepository.findById(id)
                .map(parentsMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Parent not found by " + id));
    }

    @Override
    public AddressDTO getAddressByParentId(UUID parentId) {
        Parents parent = parentsRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found by " + parentId));

        return addressMapper.toDto(parent.getAddress());
    }

    @Override
    public ParentsDTO create(ParentsDTO parentsDTO) {
        Parents savedParents = parentsRepository.save(parentsMapper
                .toEntity(parentsDTO));

        return parentsMapper.toDto(savedParents);
    }

    @Override
    public ParentsDTO update(UUID id, ParentsDTO parentsDTO) {
        Parents existingParent = parentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found by " + id));

        existingParent.setFirstName(parentsDTO.getFirstName());
        existingParent.setLastName(parentsDTO.getLastName());
        existingParent.setBirthday(parentsDTO.getBirthday());

        return parentsMapper.toDto(parentsRepository.save(existingParent));
    }


    @Override
    public void delete(UUID id) {
        if (parentsRepository.existsById(id)) {
            throw new RuntimeException("Parent not found by " + id);
        }
        parentsRepository.deleteById(id);
    }
}

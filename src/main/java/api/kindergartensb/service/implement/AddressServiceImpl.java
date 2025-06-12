package api.kindergartensb.service.implement;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.entity.Address;
import api.kindergartensb.mapper.AddressMapper;
import api.kindergartensb.repository.AddressRepository;
import api.kindergartensb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository repository, AddressMapper mapper, AddressMapper addressMapper, AddressRepository addressRepository) {
        this.repository = repository;
        this.mapper = mapper;

    }

    @Override
    public AddressDTO create(AddressDTO dto) {
        Address address = mapper.toEntity(dto);
        return mapper.toDto(repository.save(address));
    }

    @Override
    public List<AddressDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getById(UUID id) {
        Address address = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        return mapper.toDto(address);
    }

    @Override
    public AddressDTO update(UUID id, AddressDTO dto) {
        Address existingAddress = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        Address updated = mapper.toEntity(dto);
        updated.setUuid(existingAddress.getUuid());
        return mapper.toDto(repository.save(updated));
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Address not found with id " + id);
        }
        repository.deleteById(id);

    }
}


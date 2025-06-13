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
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository repository, AddressMapper addressMapper) {
        this.repository = repository;
        this.addressMapper = addressMapper;

    }

    @Override
    public AddressDTO create(AddressDTO dto) {
        Address address = addressMapper.toEntity(dto);
        return addressMapper.toDto(repository.save(address));
    }

    @Override
    public List<AddressDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getById(UUID id) {
        Address address = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        return addressMapper.toDto(address);
    }

    @Override
    public AddressDTO update(UUID id, AddressDTO dto) {
        Address existingAddress = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        Address updated = addressMapper.toEntity(dto);
        updated.setUuid(existingAddress.getUuid());
        return addressMapper.toDto(repository.save(updated));
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Address not found with id " + id);
        }
        repository.deleteById(id);

    }

    @Override
    public AddressDTO getByPlz(String plz) {
        return null;
    }

    //todo
//    @Override
//    public AddressDTO getByPlz(String plz) {
//        Address address = repository.findByPlz(plz)
//                .orElseThrow(() -> new RuntimeException("Address not found with plz " + plz));
//    return addressMapper.toDto(address);
//    }
//todo
    @Override
    public AddressDTO getByStreet(String street) {
        return null;
    }
}


package api.kindergartensb.service;

import api.kindergartensb.dto.AddressDTO;
import java.util.List;
import java.util.UUID;

public interface AddressService {

    AddressDTO create(AddressDTO dto);
    List<AddressDTO> getAll();
    AddressDTO getById(UUID id);
    AddressDTO update(UUID id, AddressDTO dto);
    void delete(UUID id);
    AddressDTO getByPlz(String plz);
    AddressDTO getByStreet(String street);

}

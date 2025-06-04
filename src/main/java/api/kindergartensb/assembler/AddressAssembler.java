package api.kindergartensb.assembler;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.entity.Address;

public class AddressAssembler {

    public static AddressDTO toDto(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDTO.builder()
                .plz(address.getPlz())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .build();

    }

    public static Address toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }

        Address address = new Address();
        address.setPlz(dto.getPlz());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());

        return address;
    }
}

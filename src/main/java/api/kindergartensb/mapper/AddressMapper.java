package api.kindergartensb.mapper;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDto(Address address);
    Address toEntity(AddressDTO addressDTO);

}

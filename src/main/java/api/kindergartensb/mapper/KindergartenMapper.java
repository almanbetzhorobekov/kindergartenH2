package api.kindergartensb.mapper;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        GroupMapper.class,
        EducatorMapper.class})
public interface KindergartenMapper {

    @Mapping(source = "address", target = "address")
    KindergartenDTO toDto(Kindergarten kindergarten);

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "educators", ignore = true)
    Kindergarten toEntity(KindergartenDTO kindergartenDTO);

}

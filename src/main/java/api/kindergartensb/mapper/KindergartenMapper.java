package api.kindergartensb.mapper;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        GroupMapper.class,
        EducatorMapper.class})//, builder = @Builder(disableBuilder = false
public interface KindergartenMapper {

    @Mapping(source = "address", target = "addressDTO")

    KindergartenDTO toDto(Kindergarten kindergarten);

    @Mapping(source = "addressDTO", target = "address")

    @Mapping(target = "groups", ignore = true)//При меппинге он может оставить в пустую, и можно добавить потом
    @Mapping(target = "educators", ignore = true)
    Kindergarten toEntity(KindergartenDTO kindergartenDTO);

}

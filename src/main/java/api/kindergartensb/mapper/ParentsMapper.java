package api.kindergartensb.mapper;

import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Parents;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        ChildMapper.class
})
public interface ParentsMapper {
    @Mapping(target = "childrenId", ignore = true)
    @Mapping(source = "address", target = "addressDTO")
    ParentsDTO toDto(Parents parent);

    @Mapping(source = "addressDTO", target = "address")
    Parents toEntity(ParentsDTO dto);

}

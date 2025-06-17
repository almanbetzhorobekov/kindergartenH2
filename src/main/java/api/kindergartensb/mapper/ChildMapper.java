package api.kindergartensb.mapper;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface ChildMapper {

//    @Mapping(source = "group.name", target = "groupName")
//    @Mapping(source = "group.kindergarten.name", target = "kindergarten")
    ChildDTO toDTO(Child child);

//    @InheritInverseConfiguration
//    @Mapping(target = "group", ignore = true)
//    @Mapping(target = "uuid", ignore = true)
    Child toEntity(ChildDTO childDTO);
}

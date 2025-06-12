package api.kindergartensb.mapper;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface ChildMapper {

    @Mapping(source = "uuid", target = "id")
    @Mapping(source = "group.name", target = "groupName")
    @Mapping(source = "group.kindergarten.name", target = "kindergarten")
    @Mapping(source = "parents", target = "parents")
    @Mapping(source = "age", target = "ignore")
    ChildDTO toDTO(Child child);

    @InheritInverseConfiguration
    @Mapping(target = "group", source = "GroupMapper")
    @Mapping(target = "id", source = "uuid")
    Child toEntity(ChildDTO childDTO);

}

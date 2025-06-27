package api.kindergartensb.mapper;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChildMapper {

//    @Mapping(target = "groupId", source = "group.uuid")
//    @Mapping(target = "parentsId", source = "parents", qualifiedByName = "mapParentsToIds")
//    ChildDTO toDto(Child entity);
//
//    @Mapping(target = "group", source = "groupId", qualifiedByName = "uuidToGroup")
//    @Mapping(target = "parents", source = "parentsId", qualifiedByName = "mapIdsToParents")
//    Child toEntity(ChildDTO dto);


}

package api.kindergartensb.mapper;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;
import api.kindergartensb.entity.Parents;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ChildMapper {

    @Mapping(target = "groupId", source = "group.uuid")
    @Mapping(target = "parentsId", source = "parents", qualifiedByName = "mapParentsToIds")
    ChildDTO toDto(Child entity);

    @Mapping(target = "group", source = "groupId", qualifiedByName = "mapGroupFromId")
    @Mapping(target = "parents", source = "parentsId", qualifiedByName = "mapIdsToParents")
    Child toEntity(ChildDTO dto);

    //pereobrazovanie List<Parents> na List<UUID>
    @Named("mapParentsToIds")
    default List<UUID> mapParentsToIds(List<Parents> parents) {
        if (parents == null) {
            return null;
        }
        return parents.stream()
                .map(Parents::getUuid)
                .collect(Collectors.toList());
    }
    //Pereobrazovanie List<UUID> -> List<Parents>
    @Named("mapIdsToParents")
    default List<Parents> mapIdsToParents(List<UUID> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream()
                .map(id -> Parents.builder().uuid(id).build())
                .collect(Collectors.toList());
    }
    //Pereobrazovanie UUID -> Group
    @Named("mapGroupFromId")
    default Group mapGroupFromId(UUID id) {
        if (id == null) {
            return null;
        }
        return Group.builder().uuid(id).build();
    }

}

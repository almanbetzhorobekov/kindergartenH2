package api.kindergartensb.mapper;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {
        ParentsMapper.class
})
public interface EducatorMapper {

    @Mapping(source = "groups", target = "groupIds", qualifiedByName = "mapGroupListToIds")
    @Mapping(source = "address", target = "addressDTO")
    EducatorDTO toDto(Educator educator);

    @Mapping(source = "groupIds", target = "groups", qualifiedByName = "mapIdsToGroupList")
    @Mapping(source = "addressDTO", target = "address")
    Educator toEntity(EducatorDTO educatorDTO);
    List<EducatorDTO> toDtoList(List<Educator> educators);
    List<Educator> toEntityList(List<EducatorDTO> dtos);

    @Named("mapGroupListToIds")
    default List<UUID> mapGroupListToIds(List<Group> groups) {
        if (groups == null) return null;
        return groups.stream()
                .map(Group::getUuid)
                .collect(Collectors.toList());
    }

    @Named("mapIdsToGroupList")
    default List<Group> mapIdsToGroupList(List<UUID> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> Group.builder().uuid(id).build())
                .collect(Collectors.toList());
    }
}

package api.kindergartensb.mapper;

import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;
@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(source = "educator.uuid", target = "educatorId")
    GroupDTO toDto(Group entity);

    @Mapping(source = "educatorId", target = "educator", qualifiedByName = "mapEducatorFromId")
    Group toEntity(GroupDTO dto);

    @Named("mapEducatorFromId")
    default Educator mapEducatorFromId(UUID id) {
        if (id == null) return null;
        return Educator.builder().uuid(id).build();
    }
}

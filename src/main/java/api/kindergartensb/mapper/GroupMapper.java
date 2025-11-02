package api.kindergartensb.mapper;

import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Kindergarten;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;
@Mapper(componentModel = "spring", uses = {KindergartenMapper.class})
public interface GroupMapper {

    @Mapping(source = "kindergarten.uuid", target = "kindergartenId")
    @Mapping(source = "kindergarten.kindergartenName", target = "kindergartenName")
    @Mapping(source = "educator.uuid", target = "educatorId")
    GroupDTO toDto(Group entity);

    @Mapping(source = "kindergartenId", target = "kindergarten", qualifiedByName = "mapKindergartenFromId")
    @Mapping(source = "educatorId", target = "educator", qualifiedByName = "mapEducatorFromId")
    Group toEntity(GroupDTO dto);

    @Named("mapEducatorFromId")
    default Educator mapEducatorFromId(UUID id) {
        if (id == null) return null;
        return Educator.builder().uuid(id).build();
    }

    @Named("mapKindergartenFromId")
    default Kindergarten mapKindergartenFromId(UUID id) {
        if (id == null) return null;
        return Kindergarten.builder().uuid(id).build();
    }
}

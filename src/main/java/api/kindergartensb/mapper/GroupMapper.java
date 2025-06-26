package api.kindergartensb.mapper;

import api.kindergartensb.entity.Group;
import api.kindergartensb.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    //@Mapping(source = "kindergarten.uuid", target = "kindergartenId")
//    @Mapping(source = "educator.uuid", target = "educatorId")
    GroupDTO toDto(Group group);

//    @Mapping(target = "kindergarten", ignore = true)
//    @Mapping(target = "educator", ignore = true)
    Group toEntity(GroupDTO dto);

}

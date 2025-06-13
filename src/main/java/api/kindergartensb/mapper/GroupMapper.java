package api.kindergartensb.mapper;


import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Group;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupDTO toDto(Group group);
    Group toEntity(GroupDTO groupDTO);

}

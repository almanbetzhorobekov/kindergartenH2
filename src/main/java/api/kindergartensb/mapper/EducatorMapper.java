package api.kindergartensb.mapper;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.entity.Kindergarten;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface EducatorMapper {

    EducatorDTO toDto(Educator educator);
    Educator toEntity(EducatorDTO educatorDTO);

}

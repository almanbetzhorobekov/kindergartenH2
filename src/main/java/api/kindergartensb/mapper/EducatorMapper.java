package api.kindergartensb.mapper;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface EducatorMapper {

    EducatorDTO toDto(Educator educator);
    Educator toEntity(EducatorDTO educatorDTO);

}

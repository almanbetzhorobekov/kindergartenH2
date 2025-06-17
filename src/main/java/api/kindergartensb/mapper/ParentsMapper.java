package api.kindergartensb.mapper;

import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Parents;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface ParentsMapper {

    ParentsDTO toDTO(Parents parents);
    Parents toParents(ParentsDTO parentsDTO);
}

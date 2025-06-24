package api.kindergartensb.mapper;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface ChildMapper {

    ChildDTO toDTO(Child child);
    Child toEntity(ChildDTO childDTO);
}

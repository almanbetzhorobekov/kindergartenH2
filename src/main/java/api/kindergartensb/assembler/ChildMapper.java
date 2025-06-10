package api.kindergartensb.assembler;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChildMapper {

    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);
    ChildDTO toDTO(Child child);
}

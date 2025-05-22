package api.kindergartensb.assembler;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//das ist ein bean Spring
public interface ChildAssembler {
    ChildDTO toDto(Child entity);
    Child toEntity(ChildDTO childDTO);
}


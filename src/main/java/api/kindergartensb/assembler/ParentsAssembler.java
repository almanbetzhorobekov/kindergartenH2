package api.kindergartensb.assembler;


import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Parents;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ParentsAssembler {
    ParentsDTO map(Parents parents);
    Parents map(ParentsDTO dto);

    List<ParentsDTO> map(List<Parents> parents);
    List<Parents> mapDTO(List<ParentsDTO> parentsDto);
}


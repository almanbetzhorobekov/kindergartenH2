package api.kindergartensb.mapper;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Kindergarten;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KindergartenMapper {

    KindergartenDTO toDto(Kindergarten kindergarten);
    Kindergarten toEntity(KindergartenDTO kindergartenDTO);
}

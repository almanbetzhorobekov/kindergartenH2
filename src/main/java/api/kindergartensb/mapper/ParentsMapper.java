package api.kindergartensb.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ParentsMapper.class})
public interface ParentsMapper {

}

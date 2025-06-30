package api.kindergartensb.mapper;

import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;
@Mapper(componentModel = "spring")//@Autowired
public interface GroupMapper {

    @Mapping(source = "educator.uuid", target = "educatorId")//nimmt uuid von Educator entity und speichert als
        // EducatorId(EducatorDto)
    GroupDTO toDto(Group entity);

    @Mapping(source = "educatorId", target = "educator", qualifiedByName = "mapEducatorFromId")
    Group toEntity(GroupDTO dto);
    // S MapStruct mojno pryama ukazat s kakim metodom mojno pereobrazavat odno pole v drugoe v etom sluchae nujno
    //ispolzovap qualifiedByName= i pered Methodom my doljny davat emu imya
    @Named("mapEducatorFromId")
    default Educator mapEducatorFromId(UUID id) {
        if (id == null) return null;
        return Educator.builder().uuid(id).build();
    }
    //Takie methody chtoby sopostovlyat raznye tipy dannyh. Naprimer Kogda pereobrazuem DTO -> Entity i hotim
    //polojit educatorId(UUID) v pole educator(entity tipa Educator)
}

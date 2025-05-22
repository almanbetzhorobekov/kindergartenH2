package api.kindergartensb.assembler;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
@Mapper(componentModel = "spring")
public interface EducatorAssembler extends JpaRepository<EducatorDTO, UUID> {
    Educator toEntity(EducatorDTO educatorDTO);
    EducatorDTO toDTO(Educator entity);
}

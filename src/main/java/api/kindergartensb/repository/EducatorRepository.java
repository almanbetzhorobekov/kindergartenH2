package api.kindergartensb.repository;

import api.kindergartensb.entity.Educator;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducatorRepository extends JpaRepository<Educator, UUID> {

}

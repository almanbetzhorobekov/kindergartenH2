package api.kindergartensb.repository;

import api.kindergartensb.dto.KindergartenDTO;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindergartenRepository extends JpaRepository<KindergartenDTO, Integer> {
}

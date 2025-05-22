package api.kindergartensb.repository;

import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsRepository extends JpaRepository<ParentsDTO, Long> {
    Parents findByLastName(String lastName);

}

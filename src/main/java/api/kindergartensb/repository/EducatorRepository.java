package api.kindergartensb.repository;

import api.kindergartensb.entity.Educator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EducatorRepository extends JpaRepository<Educator, UUID> {
    List<Educator> findByFirstName(String firstName);
    List<Educator> findByKindergarten_KindergartenName(String kindergartenName);

}

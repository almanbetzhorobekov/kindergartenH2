package api.kindergartensb.repository;


import api.kindergartensb.entity.Kindergarten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KindergartenRepository extends JpaRepository<Kindergarten, UUID> {
    Optional<Kindergarten> findByKindergartenName(String kindergartenName);

}

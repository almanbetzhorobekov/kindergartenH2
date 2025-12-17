package api.kindergartensb.repository;


import api.kindergartensb.entity.Kindergarten;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface KindergartenRepository extends JpaRepository<Kindergarten, UUID> {


    @EntityGraph(attributePaths = {"address"})
    List<Kindergarten> findAll();

    @EntityGraph(attributePaths = {"groups"})
    Optional<Kindergarten> findWithGroupsByUuid(UUID id);
}

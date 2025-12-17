package api.kindergartensb.repository;

import api.kindergartensb.entity.Parents;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParentsRepository extends JpaRepository<Parents, UUID> {

    List<Parents> findByChildren_Uuid(UUID uuid);
}

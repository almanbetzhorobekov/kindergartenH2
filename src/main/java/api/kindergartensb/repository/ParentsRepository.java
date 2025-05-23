package api.kindergartensb.repository;

import api.kindergartensb.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParentsRepository extends JpaRepository<Parents, UUID> {
    Parents findChildByLastName(String lastName);
    List<Parents> findByLastName(String lastName);
}

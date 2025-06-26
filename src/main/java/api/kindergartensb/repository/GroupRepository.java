package api.kindergartensb.repository;

import api.kindergartensb.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

}

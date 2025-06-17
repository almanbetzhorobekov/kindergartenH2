package api.kindergartensb.repository;

import api.kindergartensb.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ChildRepository extends JpaRepository<Child, UUID> {

    List<Child> findByGroup_Educator_Uuid(UUID educatorId);
    List<Child> findByGroupName(String groupName);
    List<Child> findByLastName(String lastName);
    List<Child> findByAgeBetween(int min, int max);
    List<Child> findByGroup_Kindergarten_Name(String kindergartenName);

}

package api.kindergartensb.repository;

import api.kindergartensb.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    Group findByGroupName(String groupName);
    List<Group> findByKindergarten_KindergartenName(String kindergartenName);
}

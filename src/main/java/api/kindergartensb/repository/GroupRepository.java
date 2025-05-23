package api.kindergartensb.repository;

import api.kindergartensb.dto.GroupDTO;

import api.kindergartensb.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    Group findByGroupName(String groupName);
    GroupDTO saveByGroupName(Group group);
}

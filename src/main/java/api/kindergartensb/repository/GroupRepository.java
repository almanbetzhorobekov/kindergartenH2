package api.kindergartensb.repository;

import api.kindergartensb.dto.GroupDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupDTO, Long> {
    GroupDTO findByGroupName(String groupName);
}

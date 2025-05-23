package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Group;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static api.kindergartensb.dto.GroupDTO.MAX_CHILD;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    public void saveGroupByGroupName(String groupName) {
        Group group = new Group();
        group.setGroupName(groupName);
        repository.save(group);

    }

    @Override
    public boolean addChildToGroup(GroupDTO groupDTO, ChildDTO childDTO) {
        if (groupDTO.getKinderList().size() < MAX_CHILD) {
            childDTO.setGroupDTO(groupDTO);
            groupDTO.getKinderList().add(childDTO);
            return true;
        } else {
            throw new IllegalStateException("Group is already full");
        }
    }

    @Override
    public boolean removeChildFromGroup(GroupDTO groupDTO, ChildDTO childDTO) {
        boolean isRemoved = groupDTO.getKinderList().remove(childDTO);
        if(isRemoved) {
            childDTO.setGroupDTO(null);
        }
        return isRemoved;
    }

    @Override
    public void displayChildNames(GroupDTO groupDTO) {
        for (ChildDTO childDTO : groupDTO.getKinderList()) {
            System.out.println(childDTO.getFullName());
        }
    }
}

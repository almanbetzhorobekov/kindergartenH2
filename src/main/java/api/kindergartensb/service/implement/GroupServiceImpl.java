package api.kindergartensb.service.implement;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupService;
import org.springframework.stereotype.Service;

import static api.kindergartensb.dto.GroupDTO.MAX_CHILD;

@Service
public class GroupServiceImpl implements GroupService {

    public GroupServiceImpl(GroupRepository groupRepository) {
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

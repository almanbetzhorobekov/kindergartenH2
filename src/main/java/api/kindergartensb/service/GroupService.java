package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.GroupDTO;

public interface GroupService {
    boolean addChildToGroup(GroupDTO groupDTO,  ChildDTO childDTO);
    boolean removeChildFromGroup(GroupDTO groupDTO,  ChildDTO childDTO);
    void displayChildNames(GroupDTO groupDTO);
}

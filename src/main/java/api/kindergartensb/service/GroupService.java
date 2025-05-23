package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;

public interface GroupService {
    boolean addChildToGroup(Group group, Child child);
    boolean removeChildFromGroup(Group group,  Child child);
    void displayChildNames(Group group);
    void saveGroupByGroupName(String groupName);
}

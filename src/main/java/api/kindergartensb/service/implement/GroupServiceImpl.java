package api.kindergartensb.service.implement;

import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.GroupService;
import org.springframework.stereotype.Service;

import static api.kindergartensb.dto.GroupDTO.MAX_CHILD;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final ChildRepository childRepository;
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository repository, ChildRepository childRepository, GroupRepository groupRepository) {
        this.repository = repository;
        this.childRepository = childRepository;
        this.groupRepository = groupRepository;
    }

    public void saveGroupByGroupName(String groupName) {
        Group group = new Group();
        group.setGroupName(groupName);
        repository.save(group);

    }

    @Override
    public boolean addChildToGroup(Group group, Child child) {
        if (group.getKinderList().size() < MAX_CHILD) {
            child.setGroup(group);
            group.getKinderList().add(child);
            childRepository.save(child);
            groupRepository.save(group);
            return true;
        } else {
            throw new IllegalStateException("Group is already full");
        }
    }

    @Override
    public boolean removeChildFromGroup(Group group, Child child) {
        boolean isRemoved = group.getKinderList().remove(child);
        if(isRemoved) {
            child.setGroup(null);
        }
        return isRemoved;
    }

    @Override
    public void displayChildNames(Group group) {
        for (Child child : group.getKinderList()) {
            System.out.println(child.getFullName());
        }
    }
}

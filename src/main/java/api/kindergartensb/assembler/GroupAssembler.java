package api.kindergartensb.assembler;

import api.kindergartensb.entity.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupAssembler {
    default String map(Group group) {
        return group != null ? group.getGroupName() : null;
    }

    default Group map(String groupName) {
        if (groupName == null) return null;
        Group group = new Group();
        group.setGroupName(groupName);
        return group;
    }
}


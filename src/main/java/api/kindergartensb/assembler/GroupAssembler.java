package api.kindergartensb.assembler;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupAssembler {

    public static GroupDTO toDto(Group group) {
        if (group == null) {
            return null;
        }

        GroupDTO dto = new GroupDTO();
        dto.setGroupName(group.getGroupName());

        if (group.getEducator() != null) {
            dto.setEducatorDTO(group.getEducator().getFullName());
        }

        if (group.getKindergarten() != null) {
            dto.setKindergartenDTO(group.getKindergarten().getName());
        }

        if (group.getChild() != null) {
            List<ChildDTO> childDTOList = new ArrayList<>();
            for (Child child : group.getChild()) {
                childDTOList.add(ChildAssembler.toDto(child));
            }
            dto.setKinderList(childDTOList);
        }
        return dto;
    }


}

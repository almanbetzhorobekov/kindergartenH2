package api.kindergartensb.assembler.AssemblerClass;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.entity.Kindergarten;

import java.util.ArrayList;
import java.util.List;

public class GroupAssembler {

    public static GroupDTO toDto(Group group) {
        if (group == null) {
            return null;
        }

        GroupDTO.GroupDTOBuilder builder = GroupDTO.builder();

        builder.kindergartenDTO(group.getGroupName());
        builder.educatorDTO(group.getEducator().getFullName());

        if (group.getKindergarten() != null) {
            builder.kindergartenDTO(group.getKindergarten().getName());
        }

        if (group.getEducator() != null) {
            builder.educatorDTO(group.getEducator().getFullName());
        }
        List<ChildDTO> childList = new ArrayList<>();
        if (group.getChild() != null) {
            for (Child child : group.getChild()) {
                ChildDTO childDTO = ChildAssembler.toDto(child);
                if (childDTO != null) {
                    childList.add(childDTO);
                }
            }
        }
        return GroupDTO.builder()
                .groupName(group.getGroupName())
                .kindergartenDTO(group.getKindergarten().getName())
                .educatorDTO(group.getEducator().getFullName())
                .kinderList(childList)
                .build();

    }

    public static Group toEntity(GroupDTO dto, Kindergarten kindergarten, Educator educator, List<Child> children) {
        if (dto == null) {
            return null;
        }

        return Group.builder()
                .groupName(dto.getGroupName())
                .kindergarten(kindergarten)
                .educator(educator)
                .child(children)
                .build();
    }


}

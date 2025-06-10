package api.kindergartensb.assembler.AssemblerClass;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Parents;
import api.kindergartensb.entity.Group;

import java.util.List;
import java.util.ArrayList;

public class ChildAssembler {

    public static ChildDTO toDto(Child child) {
        if (child == null) {
            return null;
        }

        ChildDTO.ChildDTOBuilder builder = ChildDTO.builder();

        builder.firstName(child.getFirstName());
        builder.lastName(child.getLastName());

        if (child.getGroup() != null) {
            builder.groupName(child.getGroup().getGroupName());

            if (child.getGroup().getKindergarten() != null) {
                builder.kindergarten(child.getGroup().getKindergarten().getName());
            }

            if (child.getGroup().getEducator() != null) {
                builder.educatorID(child.getGroup().getEducator().getFullName());
            }
        }

        List<ParentsDTO> parentsDtoList = new ArrayList<>();
        if (child.getParents() != null) {
            for (Parents parent : child.getParents()) {
                ParentsDTO parentsDTO = ParentsDTO.builder()
                        .firstName(parent.getFirstName())
                        .lastName(parent.getLastName())
                        .build();
                parentsDtoList.add(parentsDTO);
            }
        }

        builder.parents(parentsDtoList);

        return builder.build();
    }

    public static Child toEntity(ChildDTO dto, Group group, List<Parents> parentEntities) {
        if (dto == null) {
            return null;
        }

        return Child.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .group(group)
                .parents(parentEntities)
                .build();
    }

}


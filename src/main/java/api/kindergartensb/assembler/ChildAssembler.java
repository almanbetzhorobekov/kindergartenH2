package api.kindergartensb.assembler;

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

        ChildDTO dto = new ChildDTO();

        dto.setFirstName(child.getFirstName());
        dto.setLastName(child.getLastName());

        //dto.setAge(child.getBirthday());

        if (child.getGroup() != null) {
            dto.setGroupName(child.getGroup().getGroupName());

            if (child.getGroup().getKindergarten() != null) {
                dto.setKindergarten(child.getGroup().getKindergarten().getName());
            }

            if (child.getGroup().getEducator() != null) {
                dto.setEducatorID(child.getGroup().getEducator().getFullName());
            }
        }

        dto.setParents(toParentsDtoList(child.getParents()));

        return dto;
    }

    public static Child toEntity(ChildDTO dto, Group group, List<Parents> parentEntities) {
        if (dto == null) {
            return null;
        }
//
//        Child child = new Child();
//
//        child.setFirstName(dto.getFirstName());
//        child.setLastName(dto.getLastName());
//        child.setGroup(group);
//        child.setParents(parentEntities);

        return Child.builder()
                .parents(dto.getParents())
    }

    private static List<ParentsDTO> toParentsDtoList(List<Parents> parents) {
        List<ParentsDTO> dtos = new ArrayList<>();

        if (parents == null) {
            return dtos;
        }

        for (Parents parent : parents) {
            ParentsDTO dto = new ParentsDTO();
            dto.setFirstName(parent.getFirstName());
            dto.setLastName(parent.getLastName());

            dtos.add(dto);
        }

        return dtos;
    }
}


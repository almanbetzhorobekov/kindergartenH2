package api.kindergartensb.assembler;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Parents;

import java.util.ArrayList;
import java.util.List;

public class ParentsAssembler {

    public static ParentsDTO toDto(Parents parent) {
        if (parent == null) return null;

        ParentsDTO dto = new ParentsDTO();
        dto.setFirstName(parent.getFirstName());
        dto.setLastName(parent.getLastName());
        dto.setAddress(parent.getAddress());

        List<ChildDTO> childDTOList = new ArrayList<>();
        if (parent.getChild() != null) {
            for (Child child : parent.getChild()) {
                childDTOList.add(ChildAssembler.toDto(child));
            }
        }
        dto.setChildDTOList(childDTOList);

        return dto;
    }

    public static Parents toEntity(ParentsDTO dto, List<Child> childEntities) {
        if (dto == null) return null;

        return Parents.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .address(dto.getAddress())
                .child(childEntities)
                .build();
    }
}

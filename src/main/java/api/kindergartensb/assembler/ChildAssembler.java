package api.kindergartensb.assembler;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GroupAssembler.class, ParentsAssembler.class})
public interface ChildAssembler {

    static ChildDTO toDto(Child child) {
        ChildDTO dto = new ChildDTO();
        dto.setGroupName(child.getGroup().getGroupName());
        return dto;
    }

    static Child toEntity(ChildDTO childDTO) {
        Child child = new Child();
        child.setFirstName()
    }

//    ChildDTO.ChildDTOBuilder<?, ?> toDto(Child entity);
//
//    @Mapping(source = "group.groupName", target = "groupName")
//    @Mapping(source = "parents", target = "parents")
//    ChildDTO mapEntityToDto(Child entity);
//
//    @Mapping(source = "groupName", target = "group")
//    @Mapping(source = "parents", target = "parents")
//    Child toEntity(ChildDTO dto);
}



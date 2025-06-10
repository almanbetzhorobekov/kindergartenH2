package api.kindergartensb.assembler.AssemblerClass;

import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;

import java.util.ArrayList;
import java.util.List;

public class EducatorAssembler {

    public static EducatorDTO toDto(Educator educator) {

        if (educator == null) {
            return null;
        }

        EducatorDTO.EducatorDTOBuilder builder = EducatorDTO.builder();

        builder.firstName(educator.getFirstName());
        builder.lastName(educator.getLastName());
        builder.birthday(educator.getBirthday());

        if (educator.getGroupDTOList() != null) {
            List<String> groupDTOList = new ArrayList<>();
            for (Group group : educator.getGroupDTOList()) {
                if (group != null) {
                    groupDTOList.add(group.getGroupName());
                }
            }
            builder.groupDTOList(groupDTOList);
        }
        return builder.build();

    }

    public static Educator toEntity(EducatorDTO educatorDTO) {
        if (educatorDTO == null) {
            return null;
        }
        return Educator.builder()
                .firstName(educatorDTO.getFirstName())
                .lastName(educatorDTO.getLastName())
                .birthday(educatorDTO.getBirthday())
                .build();
    }

}

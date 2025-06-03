package api.kindergartensb.assembler;

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

        EducatorDTO dto = new EducatorDTO();

        dto.setFirstName(educator.getFirstName());
        dto.setLastName(educator.getLastName());
        dto.setBirthday(educator.getBirthday());

        if (educator.getKindergarten() != null) {
            dto.setKindergarten(educator.getKindergarten().getName());
        }

        if (educator.getGroupDTOList() != null) {
            List<String> groupDTOList = new ArrayList<>();
            for (Group group : educator.getGroupDTOList()) {
                if (group != null) {
                    groupDTOList.add(group.getGroupName());
                }
            }
            dto.setGroupDTOList(groupDTOList);
        }
        return dto;

    }

    public static Educator toEntity(EducatorDTO educatorDTO) {
        if (educatorDTO == null) {
            return null;
        }
        Educator educator = new Educator();

        educator.setFirstName(educatorDTO.getFirstName());
        educator.setLastName(educatorDTO.getLastName());
        educator.setBirthday(educatorDTO.getBirthday());

        return educator;
    }


}

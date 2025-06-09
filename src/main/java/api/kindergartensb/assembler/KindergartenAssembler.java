package api.kindergartensb.assembler;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.entity.Address;
import api.kindergartensb.entity.Educator;
import api.kindergartensb.entity.Group;
import api.kindergartensb.entity.Kindergarten;

import java.util.ArrayList;
import java.util.List;

public class KindergartenAssembler {

    public static KindergartenDTO toDTO(Kindergarten kindergarten) {

        if (kindergarten == null) {
            return null;
        }

        String addressStr = "";
        if (kindergarten.getAddress() != null) {
            Address address = kindergarten.getAddress();
            addressStr = address.getStreet() + ", " + address.getPlz();
        }

        List<String> groupNames = new ArrayList<>();
        if (kindergarten.getGroup() != null) {
            for (Group group : kindergarten.getGroup()) {
                groupNames.add(group.getGroupName());
            }
        }

        List<String> educatorNames = new ArrayList<>();
        if (kindergarten.getEducator() != null) {
            for (Educator educator : kindergarten.getEducator()) {
                educatorNames.add(educator.getFullName());
            }
        }

        return KindergartenDTO.builder()
                .name(kindergarten.getName())
                .addressDTO(addressStr)
                .groupDTOS(groupNames)
                .educatorDTOList(educatorNames)
                .build();

    }

    public static Kindergarten toEntity(KindergartenDTO dto,
                                        Address address,
                                        List<Group> groups,
                                        List<Educator> educators) {

        if (dto == null) {
            return null;
        }

        Kindergarten kindergarten = new Kindergarten();
        kindergarten.setKindergartenName(dto.getName());
        kindergarten.setAddress(address);
        kindergarten.setGroup(groups);
        kindergarten.setEducator(educators);
        return kindergarten;

    }
}

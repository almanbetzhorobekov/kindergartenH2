package api.kindergartensb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class KindergartenDTO {

    private final String name;
    private final AddressDTO addressDTO;
    private final List<GroupDTO> groupDTOS;
    private List<EducatorDTO> educatorDTOList;
    private final int MAX_GROUP = 10;

    public KindergartenDTO(String name, AddressDTO addressDTO, List<GroupDTO> groupDTOS) {

        this.name = name;
        this.addressDTO = addressDTO;
        this.groupDTOS = groupDTOS;
    }

    /**
     * Assigns an educator to this kindergarten.
     * Note: The educator is not stored in a list, only linked to this kindergarten.
     *
     * @param educatorDTO The educator to be assigned.
     */
//
//    public void addEducator(EducatorDTO educatorDTO) {
//        educatorDTO.setKindergarten(this);
//        if (educatorDTOList == null) {
//            educatorDTOList = new ArrayList<>();
//        }
//        educatorDTOList.add(educatorDTO);
//    }
//
//    /**
//     * Adds a group to the kindergarten and sets its reference to this kindergarten.
//     *
//     * @param groupDTO The group to be added.
//     *
//     */
//    public void addGroup(GroupDTO groupDTO) {
//        if(groupDTOS.size() < MAX_GROUP) {
//            this.groupDTOS.add(groupDTO);
//            groupDTO.setKindergarten(this);
//        }
//        System.out.println("In Kindergarten there cannot be groups larger than " + MAX_GROUP);
//    }
//
//    /**
//     * Gets the count of the groups
//     * @return The count of the groups
//     */
//    public int totalCountGroup() {
//        System.out.println("Kindergarten has: " + groupDTOS.size() + " groups.");
//        return groupDTOS.size();
//    }

}
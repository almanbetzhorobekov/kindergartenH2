package api.kindergartensb.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a parent in the kindergarten system.
 *
 * <p>This class inherits from {@link Person} and provides additional attributes
 * specific to parents, such as the associated child. The {@link Builder} pattern
 * is used to create instances of this class.</p>
 */

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ParentsDTO extends Person{

    private AddressDTO address;
    private List<ChildDTO> childDTOList = new ArrayList<>();

    /**
     * Sets the child associated with this parent.
     *
     * @param childDTO The child to be associated with the parent.
     */
    public void addChild(ChildDTO childDTO) {
        this.childDTOList.add(childDTO);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }
//
//    public AddressDTO getAddress() {
//        return getAddressDTO();
//    }

    public void childName() {
        System.out.println("Parents has " + childDTOList.size() + " children.");
        for (int i = 0; i < childDTOList.size(); i++) {
            ChildDTO childDTO = childDTOList.get(i);
            System.out.println("Kind " + (i + 1) + ":");
            System.out.println(childDTO.getFullName());
        }
    }

    /**
     * Returns the role of the person as "Parent"
     * @return The role of the person, which is "Parent".
     */

    @Override
    public String getRole() {
        return "Parent";
    }

}
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

    private String address;
    private List<String> childDTOList = new ArrayList<>();

    @Override
    public String getFullName() {
        return super.getFullName();
    }
//
//
//    public void childName() {
//        System.out.println("Parents has " + childDTOList.size() + " children.");
//        for (int i = 0; i < childDTOList.size(); i++) {
//            ChildDTO childDTO = childDTOList.get(i);
//            System.out.println("Kind " + (i + 1) + ":");
//            System.out.println(childDTO.getFullName());
//        }
//    }


    @Override
    public String getRole() {
        return "Parent";
    }

}
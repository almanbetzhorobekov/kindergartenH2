package api.kindergartensb.dto;

import lombok.*;
import java.util.List;
/**
 * The Educator class represents an educator in the kindergarten.
 * An educator is a person associated with a kindergarten and multiple groups.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducatorDTO extends Person {

    private KindergartenDTO kindergartenDTO;
    private List<GroupDTO> groupDTOList;

    /**
     * Returns the role of the person, which is "Educator".
     *
     * @return The role as a string.
     */
    @Override
    public String getRole() {
        return "Educator";
    }
//
//    @Override
//    public String toString() {
//        return "Educator:" + getFullName() +
//                "\nBirthday: "+ birthday +
//                "\nAdresse: " + addressDTO +
//                "\nKindergarten: " + kindergartenDTO.getName();
//    }

}
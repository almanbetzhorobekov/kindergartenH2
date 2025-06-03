package api.kindergartensb.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.swing.*;
import java.util.List;
/**
 * The Educator class represents an educator in the kindergarten.
 * An educator is a person associated with a kindergarten and multiple groups.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EducatorDTO extends Person {

    private String kindergarten;
    private List<String> groupDTOList;

    /**
     * Returns the role of the person, which is "Educator".
     *
     * @return The role as a string.
     */
    @Override
    public String getRole() {
        return "Educator";
    }

}
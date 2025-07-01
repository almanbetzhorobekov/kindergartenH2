package api.kindergartensb.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

/**
 * The Educator class represents an educator in the kindergarten.
 * An educator is a person associated with a kindergarten and multiple groups.
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@RequiredArgsConstructor
@Data
public class EducatorDTO extends Person {

    private UUID uuid;


    private List<UUID> groupIds;

    private AddressDTO addressDTO;

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
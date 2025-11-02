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
    private String email;
    private String phoneNumber;
    private UUID kindergartenId;
    private List<UUID> groupIds;
    private AddressDTO addressDTO;
}
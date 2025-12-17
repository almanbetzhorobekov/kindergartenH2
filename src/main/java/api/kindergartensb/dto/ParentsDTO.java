package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

/**
 * Represents a parent in the kindergarten system.
 *
 * <p>This class inherits from {@link Person} and provides additional attributes
 * specific to parents, such as the associated child. The {@link Builder} pattern
 * is used to create instances of this class.</p>
 */

@RequiredArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ParentsDTO extends Person {

 //
    private UUID uuid;

    @NotNull(message = "Can not be null please add address")
    private AddressDTO addressDTO;

    private List<UUID> childrenId;

    private String phoneNumber;

    @Override
    public String getFullName() {
        return super.getFullName();
    }

}

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

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ParentsDTO extends Person {

    private String address;
    private List<ChildDTO> childDTOList = new ArrayList<>();

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public String getRole() {
        return "Parent";
    }
}

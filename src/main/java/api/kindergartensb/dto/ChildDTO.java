package api.kindergartensb.dto;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)

public class ChildDTO extends Person {

    private KindergartenDTO kindergartenDTO;
    @NotNull (message = "Age cannot be null")
    @Min(value = 1, message = "Age cannot be less than 1 year.")
    @Max(value = 6, message = "Age must not exceed 6 years.")
    private int age;
    private EducatorDTO educatorDTO;
    private List<ParentsDTO> parentList ;
    private GroupDTO groupDTO;

    @Override
    public String getRole() {
        return "Kind";
    }
    @Override
    public String getFullName() {
        return super.getFullName();
    }
}


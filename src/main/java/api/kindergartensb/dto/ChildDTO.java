package api.kindergartensb.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class ChildDTO extends Person {

    private UUID uuid;

    @NotNull(message = "Age cannot be null")
    @Min(value = 1, message = "Age cannot be less than 1 year.")
    @Max(value = 6, message = "Age must not exceed 6 years.")
    private int age;

    private List<UUID> parentsId;

    private UUID groupId;

    @Override
    public String getRole() {
        return "Kind";
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }
}


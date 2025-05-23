package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Person {
    @NotNull(message = "Firstname cannot be null")
    protected String firstName;
    @NotNull(message = "Lastname cannot be null")
    protected String lastName;
    @NotNull(message = "Birthday cannot be null")
    protected LocalDate birthday;
    protected String addressDTO;


    public abstract String getRole();
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
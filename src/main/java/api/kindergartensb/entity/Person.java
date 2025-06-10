package api.kindergartensb.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Person {
    @NotNull(message = "Firstname cannot be null")
    protected String firstName;
    @NotNull(message = "Lastname cannot be null")
    protected String lastName;
    @NotNull(message = "Birthday can not be null")
    protected LocalDate birthday;
    @ManyToOne
    protected Address address;

    public @NotNull(message = "FullName cannot be null") String getFullName() {
        return firstName +  " " + lastName;
    }
}

package api.kindergartensb.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass
public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected LocalDate birthday;

    @ManyToOne
    protected Address address;

    public void setFirstName(@NotNull(message = "Firstname cannot be null") String firstName) {
    }

    public @NotNull(message = "FullName cannot be null") String getFullName() {
        return firstName +  " " + lastName;
    }

    public @NotNull(message = "Lastname cannot be null") String getLastName() {
        return lastName;
    }

    public @NotNull(message = "Firstname cannot be null") String getFirstName() {
        return firstName;
    }
}

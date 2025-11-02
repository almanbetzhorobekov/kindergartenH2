package api.kindergartensb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Person {

    @Column(nullable = false)
    protected Integer age;
    @NotNull(message = "Firstname cannot be null")
    protected String firstName;
    @NotNull(message = "Lastname cannot be null")
    protected String lastName;
    @NotNull(message = "Birthday can not be null")
    protected LocalDate birthday;

    public @NotNull(message = "FullName cannot be null") String getFullName() {
        return firstName +  " " + lastName;
    }

    @PrePersist
    @PreUpdate
    public void calculateAge() {
        if (birthday != null) {
            this.age = Period.between(birthday, LocalDate.now()).getYears();
        }
    }

}

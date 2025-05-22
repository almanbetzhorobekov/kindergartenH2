package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
/**
 * An abstract class that serves as a base for other person-related classes
 * such as {@link ChildDTO}, {@link ParentsDTO}, {@link EducatorDTO}
 *
 * <p>This class provides common attributes like first name, last name, birthday,
 * and address, ensuring code reuse and structure optimization</p>
 *
 * <p>Since all people in the kindergarten systeme share these attributes,
 * using an abstract class is an optimal solution.</p>
 */

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
    protected AddressDTO addressDTO;

    /**
     * Abstract method that must be implemented by subclasses
     * to define the specific role of the person.
     *
     * @return The role of the person (for example: "Child", "Parent", "Educator".)
     */
    public abstract String getRole();

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
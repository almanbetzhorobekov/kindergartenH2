package api.kindergartensb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parents extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @ManyToMany
    private List<Child> child;


    public @NotNull(message = "Firstname cannot be null") String getFirstName() {
        return super.getFirstName();
    }
}

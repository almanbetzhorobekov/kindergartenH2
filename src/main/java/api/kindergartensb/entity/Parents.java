package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parents extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;
    @ManyToMany
    private List<Child> child;

//    public Parents() {
//        this.uuid = UUID.randomUUID();
//    }

}


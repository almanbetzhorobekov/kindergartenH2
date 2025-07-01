package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;


@Data
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Educator extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @OneToMany
    private List<Group> groups;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}

package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
public class Educator extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID uuid;
    @ManyToOne
    private Kindergarten kindergarten;
    @OneToMany
    private List<Group> groupDTOList;

}

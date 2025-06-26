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
    @ManyToOne
    private Kindergarten kindergarten;
    @OneToMany
    private List<Group> groupDTOList;
//
//    public Educator() {
//        this.uuid = UUID.randomUUID();
//    }

}

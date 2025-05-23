package api.kindergartensb.entity;

import jakarta.persistence.*;
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

public class Educator extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID uuid;
    @ManyToOne
    private Kindergarten kindergarten;
    @OneToMany
    private List<Group> groupDTOList;

}

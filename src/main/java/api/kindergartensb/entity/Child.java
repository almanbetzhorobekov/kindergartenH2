package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
public class Child extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToMany(mappedBy = "children", fetch = FetchType.EAGER)
    private List<Parents> parents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_uuid")
    private Group group;

}
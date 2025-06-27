package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kindergarten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String kindergartenName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educator> educators;

}

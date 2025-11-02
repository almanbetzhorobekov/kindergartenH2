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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)//CascadeType on sohranit Address vmesto s Kindergarten
    //orphanremoval on mojet udalit vmesto kindergarten drugie svyazannye objekty
    private Address address;

    @OneToMany(mappedBy = "kindergarten",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Group> groups;
//todo ändern BEZIEHUNG!
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Educator> educators;

}

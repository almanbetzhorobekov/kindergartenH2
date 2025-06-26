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

    @OneToMany
    private List<Group> groups;

    @OneToMany
    private List<Educator> educator;

    @OneToOne
    private Address address;
//
//    public Kindergarten() {
//        this.uuid = UUID.randomUUID();
//    }


}

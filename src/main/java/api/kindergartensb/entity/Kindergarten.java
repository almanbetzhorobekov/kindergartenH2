package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Kindergarten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID uuid;
    private String kindergartenName;

    @OneToMany
    private List<Group> group;

    @OneToMany

    private List<Educator> educator;
   @OneToOne
    private Address address;

    public String getName() {
        return kindergartenName;
    }
}

package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@Entity

public class Kindergarten {

    @Id
    private UUID uuid;
    @Getter
    @Setter
    private String kindergartenName;
    @OneToMany
    private List<Group> group;
    @OneToMany
    private List<Educator> educator;
    @OneToOne
    private Address address;

    public Kindergarten() {
        this.uuid = UUID.randomUUID();
    }

    public void updateName(String newName) {
        this.kindergartenName = newName;
    }

}

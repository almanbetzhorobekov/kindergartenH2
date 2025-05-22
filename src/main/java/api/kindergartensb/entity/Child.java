package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @ManyToOne
    private Group group;

    @ManyToMany

    private List<Parents> parents;
//    @Column
//    @ManyToOne
//    private Kindergarten kindergarten;
    //private Address address;
}

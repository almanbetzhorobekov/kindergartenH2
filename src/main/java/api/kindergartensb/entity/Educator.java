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

public class Educator {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID uuid;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @ManyToOne
    private Kindergarten kindergarten;
    @OneToMany
    private List<Group> groupDTOList;

}

package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID uuid;

    @ManyToOne
    private Educator educator;

    private String groupName;

    @OneToMany
    private List<Child> child;

    @OneToOne
    private Kindergarten kindergarten;

}

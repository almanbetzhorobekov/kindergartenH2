package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "groups",
        uniqueConstraints = @UniqueConstraint(columnNames = {"group_name", "kindergarten_id"}))
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<Child> childList;

    @ManyToOne
    @JoinColumn(name = "kindergarten_id")
    private Kindergarten kindergarten;

    @ManyToOne(optional = true)
    private Educator educator;

}


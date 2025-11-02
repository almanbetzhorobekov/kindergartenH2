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
@Table(name = "groups")
public class Group {//имя Group резервирован в SQL

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String groupName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList;

    @ManyToOne
    @JoinColumn(name = "kindergarten_id")
    private Kindergarten kindergarten;

    @ManyToOne(optional = true)
    private Educator educator;

}


package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "groups")
public class Group {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "VARCHAR(36)")
    private UUID uuid;
    @ManyToOne
    private Educator educator;
    private String groupName;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> child;
    @ManyToOne
    private Kindergarten kindergarten;

    public Group() {
        this.uuid = UUID.randomUUID();
    }
}

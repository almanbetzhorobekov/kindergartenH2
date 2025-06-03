package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.net.ssl.SSLSession;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

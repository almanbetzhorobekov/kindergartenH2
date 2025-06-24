package api.kindergartensb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Address {

    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String street;
    private String houseNumber;
    private String plz;

    public Address() {
        this.uuid = UUID.randomUUID();
    }
}

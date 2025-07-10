package api.kindergartensb.praesentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Child {
//Child mit 10 Parameter
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String address;
    private String nationality;
    private String language;
    private boolean hasAllergies;
    private String groupName;
    private String favoriteToy;

}

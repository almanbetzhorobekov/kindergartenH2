package api.kindergartensb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * The Address class represents an address with a postal code, street, and house number.
 * It is implemented using the Builder pattern.
 */
public class AddressDTO {

    private int plz;
    private String street;
    private int houseNumber;

}
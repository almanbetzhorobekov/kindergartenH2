package api.kindergartensb.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDTO {

    private int plz;
    private String street;
    private int houseNumber;

}
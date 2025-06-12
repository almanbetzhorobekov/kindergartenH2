package api.kindergartensb.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDTO {

    private String plz;
    private String street;
    private String houseNumber;

}
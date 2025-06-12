package api.kindergartensb.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDTO {

    public static void main(String[] args) {

    }

    @Size(min = 5, max = 5)
    private String plz;
    private String street;
    private String houseNumber;

}
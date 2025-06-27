package api.kindergartensb.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @Size(min = 5, max = 5)
    private String plz;
    private String street;
    private String houseNumber;
    
}
package api.kindergartensb.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
public class AddressDTO {

    @Size(min = 5, max = 5)
    private String plz;
    private String street;
    private String houseNumber;

}
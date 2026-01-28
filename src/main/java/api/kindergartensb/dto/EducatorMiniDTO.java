package api.kindergartensb.dto;

import java.util.UUID;

public record EducatorMiniDTO(
        UUID uuid,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        AddressDTO address
) {

}

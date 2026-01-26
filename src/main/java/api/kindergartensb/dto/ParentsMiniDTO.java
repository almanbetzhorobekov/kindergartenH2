package api.kindergartensb.dto;

import java.util.List;
import java.util.UUID;

public record ParentsMiniDTO(
        UUID uuid,
        String firstName,
        String lastName,
        String phoneNumber,
        AddressDTO address,
        List<ChildMiniDTO> children
) {
}

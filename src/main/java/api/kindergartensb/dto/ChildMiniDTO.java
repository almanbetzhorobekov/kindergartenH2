package api.kindergartensb.dto;

import java.util.UUID;

public record ChildMiniDTO(
        UUID uuid,
        String firstName,
        String lastName
) {
}

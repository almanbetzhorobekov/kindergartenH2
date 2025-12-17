package api.kindergartensb.dto;

import java.util.UUID;

public record KindergartenMiniDto(UUID uuid, String name, String plz, String street, String strNumber) {
}

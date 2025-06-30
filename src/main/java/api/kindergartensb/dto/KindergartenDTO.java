package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class KindergartenDTO {

    private UUID uuid;

    @NotNull(message = "Can not be Null")
    private final String kindergartenName;

    private final AddressDTO addressDTO;

    private List<GroupDTO> groups;

    private List<EducatorDTO> educators;



}
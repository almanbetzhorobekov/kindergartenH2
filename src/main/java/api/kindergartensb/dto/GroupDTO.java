package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {
    //@JsonProperty("id")
    private UUID uuid;

    @NotNull(message = "Group name can not be Null")
    private String groupName;

    private List<ChildDTO> childList;

    private UUID kindergartenId;

    private String kindergartenName;

    private UUID educatorId;

}
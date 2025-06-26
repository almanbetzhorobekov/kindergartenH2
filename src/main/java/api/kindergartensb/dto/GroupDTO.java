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

    private UUID uuid;

    @NotNull(message = "Group name can not be Null")
    private String groupName;

    @NotNull(message = "Kindergarten can not be Null")
    private UUID kindergartenId;

    private List<ChildDTO> kinderList;

    private UUID educatorId;



}
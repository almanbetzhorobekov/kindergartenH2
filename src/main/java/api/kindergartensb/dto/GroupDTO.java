package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Represents a group in the kindergarten.
 *A group consists of children and belongs to a specific kindergarten.
 */

@Builder
@Data
@RequiredArgsConstructor
public class GroupDTO {
    @NotNull(message = "Group name can not be Null")
    private String groupName;
    @NotNull(message = "Kindergarten can not be Null")
    private String kindergartenDTO;
    private List<ChildDTO> kinderList;
    private String educatorDTO;
    public static final int MAX_CHILD = 20;

}
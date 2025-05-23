package api.kindergartensb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a group in the kindergarten.
 *A group consists of children and belongs to a specific kindergarten.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {

    private String groupName;
    private String kindergartenDTO;
    private List<String> kinderList;
    private String educatorDTO;
    public static final int MAX_CHILD = 20;


}
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
    private KindergartenDTO kindergartenDTO;
    private List<ChildDTO> kinderList;
    private EducatorDTO educatorDTO;
    public static final int MAX_CHILD = 20;


}
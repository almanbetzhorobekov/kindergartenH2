package api.kindergartensb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class KindergartenDTO {

    private final String name;
    private final String addressDTO;
    private final List<String> groupDTOS;
    private List<String> educatorDTOList;
    private final int MAX_GROUP = 10;
}
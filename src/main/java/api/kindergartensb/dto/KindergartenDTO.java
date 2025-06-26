package api.kindergartensb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class KindergartenDTO {
    @NotNull(message = "Can not be Null")
    private final String kindergartenName;
    private final String addressDTO;
    private final List<String> groupDTOS;
    private List<String> educatorDTOList;
    private final int MAX_GROUP = 10;
}
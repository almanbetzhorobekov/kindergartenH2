package api.kindergartensb.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class ChildDTO extends Person {

    private List<UUID> parentsId;

    private UUID groupId;

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public int getAge() {
        if (birthday == null) {
            return 0;
        }
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}


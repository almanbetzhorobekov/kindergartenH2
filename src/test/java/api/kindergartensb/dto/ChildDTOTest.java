package api.kindergartensb.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ChildDTOTest {

    @Test
    void setAge() {
        ChildDTO childDTO = ChildDTO.builder()
                .age(3)
                .firstName("hallo")
                .build();

        log.info(childDTO.toString());
    }
}
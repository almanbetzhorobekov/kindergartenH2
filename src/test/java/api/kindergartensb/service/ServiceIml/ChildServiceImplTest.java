package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.service.ChildReadService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChildServiceImplTest {

    @Mock
    private ChildRepository childRepository;

    @Mock
    private ChildMapper childMapper;

    @Mock
    private ParentsMapper parentsMapper;

    @InjectMocks
    private ChildServiceImpl childService;


    @Test
    void getById_shouldReturnChildDTO_whenFound() {
        UUID id = UUID.randomUUID();
        Child child = new Child();
        ChildDTO dto = new ChildDTO();

        when(childRepository.findById(id)).thenReturn(Optional.of(child));
        when(childMapper.toDto(child)).thenReturn(dto);

        ChildDTO result = childService.getById(id);

        assertEquals(dto, result);
    }

    @Test
    void getParents() {
    }

    @Test
    void getChildrenByParentId() {
    }

    @Test
    void create() {
    }

    @Test
    void deleteChild() {
    }

    @Test
    void updateChild() {
    }

    @Test
    void isExist() {
    }
}
package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChildServiceImplTest {

    @Mock
    private ChildRepository childRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private ChildMapper childMapper;

    @Mock
    private ParentsMapper parentsMapper;

    @InjectMocks
    private ChildServiceImpl childService;

    private Child child;
    private ChildDTO childDTO;
    private UUID childId;
    private UUID groupId;

    @BeforeEach
    void setup() {
        childId = UUID.randomUUID();
        groupId = UUID.randomUUID();
        child = new Child();
        child.setActive(true);
        childDTO = new ChildDTO();
    }

    @Test
    void getAllChildren_shouldReturnPageOfDtos() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Child> childrenPage = new PageImpl<>(List.of(child), pageable, 1);

        when(childRepository.findAllByActiveTrue(any(Pageable.class))).thenReturn(childrenPage);
        when(childMapper.toDto(any(Child.class))).thenReturn(childDTO);

        Page<ChildDTO> result = childService.getAllChildren(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(1, result.getTotalPages());
        assertEquals(1, result.getContent().size());
    }

    @Test
    void getById_shouldReturnDto() {
        when(childRepository.findById(childId)).thenReturn(Optional.of(child));
        when(childMapper.toDto(child)).thenReturn(childDTO);

        ChildDTO result = childService.getById(childId);

        assertNotNull(result);
        verify(childRepository).findById(childId);
    }

    @Test
    void getById_shouldThrowException_whenNotFound() {
        when(childRepository.findById(childId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,
                () -> childService.getById(childId));
    }

    @Test
    void create_shouldSaveChild() {
        childDTO.setBirthday(LocalDate.now().minusYears(5));
        when(childMapper.toEntity(childDTO)).thenReturn(child);
        when(childRepository.save(child)).thenReturn(child);
        when(childMapper.toDto(child)).thenReturn(childDTO);

        ChildDTO result = childService.create(childDTO);

        assertNotNull(result);
        verify(childRepository).save(child);
    }

    @Test
    void updateChild_shouldUpdateFields() {
        childDTO.setBirthday(LocalDate.now().minusYears(5));
        childDTO.setFirstName("Max");
        childDTO.setLastName("Müller");

        when(childRepository.findById(childId)).thenReturn(Optional.of(child));
        when(childRepository.save(child)).thenReturn(child);
        when(childMapper.toDto(child)).thenReturn(childDTO);

        ChildDTO result = childService.updateChild(childId, childDTO);

        assertEquals("Max", result.getFirstName());
        assertEquals("Müller", result.getLastName());
    }

    @Test
    void deactivateChild_shouldSetActiveFalse() {
        when(childRepository.findById(childId)).thenReturn(Optional.of(child));
        when(childRepository.save(child)).thenReturn(child);

        childService.deactivateChild(childId);

        assertFalse(child.isActive());
        verify(childRepository).save(child);
    }

    @Test
    void changeGroup_shouldUpdateGroup() {
        Group group = new Group();
        when(childRepository.findById(childId)).thenReturn(Optional.of(child));
        when(groupRepository.findById(groupId)).thenReturn(Optional.of(group));
        when(childRepository.save(child)).thenReturn(child);
        when(childMapper.toDto(child)).thenReturn(childDTO);

        ChildDTO result = childService.changeGroup(childId, groupId);

        assertNotNull(result);
        assertEquals(group, child.getGroup());
    }

    @Test
    void isExist_shouldReturnTrue() {
        when(childRepository.existsById(childId)).thenReturn(true);
        assertTrue(childService.isExist(childId));
    }

    @Test
    void getParents_shouldReturnList() {
        ParentsDTO parentsDTO = new ParentsDTO();
        child.setParents(List.of());
        when(childRepository.findById(childId)).thenReturn(Optional.of(child));

        List<ParentsDTO> result = childService.getParents(childId);

        assertNotNull(result);
    }
}
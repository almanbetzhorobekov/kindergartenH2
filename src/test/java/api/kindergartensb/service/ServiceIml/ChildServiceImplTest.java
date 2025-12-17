package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.mapper.ParentsMapper;
import api.kindergartensb.repository.ChildRepository;
import api.kindergartensb.repository.GroupRepository;
import api.kindergartensb.service.ChildReadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ChildServiceImplTest {

    @Mock
    private ChildRepository childRepository;

    @Mock
    private ChildMapper childMapper;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private ParentsMapper parentsMapper;

    @InjectMocks
    private ChildServiceImpl childService;


    @Test
    void getById_shouldReturnChildDto_whenChildExists() {
        UUID uuid = UUID.randomUUID();
        Child child = new Child();
        ChildDTO dto = new ChildDTO();

        when(childRepository.findById(uuid)).thenReturn(Optional.of(child));
        when(childMapper.toDto(child)).thenReturn(dto);

        ChildDTO result = childService.getById(uuid);

        assertNotNull(result);
        verify(childRepository).findById(uuid);
    }

    @Test
    void getById_shouldThrowException_whenChildNotFound() {
        UUID id = UUID.randomUUID();

        when(childRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,
                () -> childService.getById(id));
    }

    @Test
    void getAllChildren_shouldReturnPageOfDtos() {
        Pageable pageable = PageRequest.of(0, 5);
        Child child = new Child();
        ChildDTO dto = new ChildDTO();

        Page<Child> page = new PageImpl<>(List.of(child));

        when(childRepository.findAllByActiveTrue(pageable)).thenReturn(page);
        when(childMapper.toDto(child)).thenReturn(dto);

        Page<ChildDTO> result = childService.getAllChildren(pageable);

        assertEquals(1, result.getTotalElements());
    }

    @Test
    void create_shouldSaveChild_whenAgeIsValid() {

        ChildDTO dto = ChildDTO.builder()
                .birthday(LocalDate.now().minusYears(5))
                .firstName("Max")
                .lastName("Müller")
                .build();


        Child entity = new Child();
        Child saved = new Child();

        when(childMapper.toEntity(dto)).thenReturn(entity);
        when(childRepository.save(entity)).thenReturn(saved);
        when(childMapper.toDto(saved)).thenReturn(dto);

        ChildDTO result = childService.create(dto);

        assertNotNull(result);
        verify(childRepository).save(entity);
    }

    @Test
    void create_shouldThrowException_whenAgeIsInvalid() {
        ChildDTO dto = ChildDTO.builder()
                .birthday(LocalDate.now().minusYears(5))
                .build();

        assertThrows(IllegalArgumentException.class,
                () -> childService.create(dto));
    }

    @Test
    void updateChild_shouldUpdateFields() {
        UUID id = UUID.randomUUID();

        Child existing = new Child();
        existing.setActive(true);

        ChildDTO dto = ChildDTO.builder()
                .birthday(LocalDate.now().minusYears(5))
                .firstName("Max")
                .lastName("Müller")
                .build();

        when(childRepository.findById(id)).thenReturn(Optional.of(existing));
        when(childRepository.save(existing)).thenReturn(existing);
        when(childMapper.toDto(existing)).thenReturn(dto);

        ChildDTO result = childService.updateChild(id, dto);

        assertEquals("Max", result.getFirstName());
    }

    @Test
    void updateChild_shouldThrowException_whenChildNotFound() {
        UUID id = UUID.randomUUID();

        ChildDTO dto = ChildDTO.builder()
                .birthday(LocalDate.now().minusYears(4)) // чтобы валидация прошла
                .build();

        when(childRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,
                () -> childService.updateChild(id, dto));
    }

    @Test
    void deactivateChild_shouldSetActiveFalse() {
        UUID id = UUID.randomUUID();
        Child child = new Child();
        child.setActive(true);

        when(childRepository.findById(id)).thenReturn(Optional.of(child));

        childService.deactivateChild(id);

        assertFalse(child.isActive());
        verify(childRepository).save(child);
    }

    @Test
    void deactivateChild_shouldThrowException_whenAlreadyInactive() {
        UUID id = UUID.randomUUID();
        Child child = new Child();
        child.setActive(false);

        when(childRepository.findById(id)).thenReturn(Optional.of(child));

        assertThrows(IllegalStateException.class,
                () -> childService.deactivateChild(id));
    }

    @Test
    void changeGroup_shouldUpdateGroup() {
        UUID childId = UUID.randomUUID();
        UUID groupId = UUID.randomUUID();

        Child child = new Child();
        child.setActive(true);

        Group group = new Group();

        when(childRepository.findById(childId)).thenReturn(Optional.of(child));
        when(groupRepository.findById(groupId)).thenReturn(Optional.of(group));
        when(childRepository.save(child)).thenReturn(child);
        when(childMapper.toDto(child)).thenReturn(new ChildDTO());

        ChildDTO result = childService.changeGroup(childId, groupId);

        assertNotNull(result);
        assertEquals(group, child.getGroup());
    }

    @Test
    void changeGroup_shouldThrowException_whenChildInactive() {
        UUID childId = UUID.randomUUID();

        Child child = new Child();
        child.setActive(false);

        when(childRepository.findById(childId)).thenReturn(Optional.of(child));

        assertThrows(IllegalStateException.class,
                () -> childService.changeGroup(childId, UUID.randomUUID()));
    }

}
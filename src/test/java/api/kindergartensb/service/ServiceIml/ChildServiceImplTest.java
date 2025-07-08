package api.kindergartensb.service.ServiceIml;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Group;
import api.kindergartensb.entity.Parents;
import api.kindergartensb.mapper.ChildMapper;
import api.kindergartensb.repository.ChildRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ChildServiceImplTest {

    @Mock
    private ChildRepository childRepository;

    @Mock
    private ChildMapper childMapper;

    @InjectMocks
    private ChildServiceImpl sut;

    @Test
    void getById() {
          LocalDate parentsBirthday = LocalDate.of(2010, 1, 1);
          Parents parents = new Parents();
          parents.setFirstName("Paul");
          parents.setAge(20);
          parents.setLastName("LstName");
          parents.setBirthday(parentsBirthday);
          Group group = new Group();
          group.setGroupName("group");

          UUID childId = UUID.randomUUID();
          LocalDate birthday = LocalDate.of(2020, 1, 1);
          Child child = new Child();
          child.setUuid(childId);
          child.setFirstName("John");
          child.setLastName("Doe");
          child.setBirthday(birthday);
          child.setParents(List.of(parents));
          child.setGroup(group);
        Mockito.when(childRepository.findById(childId)).thenReturn(Optional.of(child));
        Mockito.when(childMapper.toDto(child)).thenReturn(new ChildDTO());

        ChildDTO childDTO = sut.getById(childId);

        Mockito.verify(childRepository.findById(childId), Mockito.times(1));
        Mockito.verify(childMapper.toDto(child), Mockito.times(1));

    }

    @Test
    void getAllChildren() {
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
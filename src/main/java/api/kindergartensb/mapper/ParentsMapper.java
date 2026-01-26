package api.kindergartensb.mapper;

import api.kindergartensb.dto.ParentsDTO;
import api.kindergartensb.entity.Child;
import api.kindergartensb.entity.Parents;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        ChildMapper.class
})
public interface ParentsMapper {
    @Mapping(target = "addressDTO", source = "address")
    @Mapping(target = "childrenId", source = "children")
    ParentsDTO toDto(Parents parent);

    @Mapping(source = "addressDTO", target = "address")
    Parents toEntity(ParentsDTO dto);
    default List<UUID> mapChildrenToIds(List<Child> children) {
        if (children == null) return null;
        return children.stream()
                .map(Child::getUuid)
                .collect(Collectors.toList());
    }
}

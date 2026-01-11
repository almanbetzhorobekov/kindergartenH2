package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChildReadService {

    ChildDTO getById(UUID uuid);
    Page<ChildDTO> getAllChildren(Pageable pageable);
    List<ChildDTO> getAllInactive();
    List<ParentsDTO> getParents(UUID uuid);
    List<ChildDTO> getChildrenByParentId(UUID parentId);
    boolean isExist(UUID uuid);

}

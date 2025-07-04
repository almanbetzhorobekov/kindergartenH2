package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;

import java.util.List;
import java.util.UUID;

public interface ChildReadService {

    ChildDTO getById(UUID id);
    List<ChildDTO> getAllChildren();
    List<ParentsDTO> getParents(UUID id);
    List<ChildDTO> getChildrenByParentId(UUID parentId);
    boolean isExist(UUID id);

}

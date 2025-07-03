package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;

import java.util.List;
import java.util.UUID;

public interface ChildReadService {

    ChildDTO getById(UUID id);
    List<ChildDTO> getAllChildren();
    List<ParentsDTO> getParents();
    List<ChildDTO> getChildrenByParentId(UUID parentId);

}

package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import java.util.List;
import java.util.UUID;

public interface ParentsService {

    void childName(ChildDTO childDTO);
    void removeChild(ChildDTO childDTO);
    void addChild(ChildDTO childDTO);
    ParentsDTO createParent(ParentsDTO dto);
    List<ParentsDTO> getAllParents();
    ParentsDTO getParentById(UUID id);
    void updateParent(UUID id, ParentsDTO dto);
    ParentsDTO deleteParent(UUID id);

}

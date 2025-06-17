package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.dto.ParentsDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ParentsService {

    void childName(ChildDTO childDTO);
    void removeChild(ChildDTO childDTO);
    void addChild(ChildDTO childDTO);
    void createParent(ParentsDTO dto);
    void getAllParents();
    void getParentById(UUID id);
    void updateParent(UUID id, ParentsDTO dto);
    void deleteParent(UUID id);

}

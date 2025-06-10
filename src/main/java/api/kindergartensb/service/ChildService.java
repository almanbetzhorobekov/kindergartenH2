package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import api.kindergartensb.entity.Child;


import java.util.List;
import java.util.UUID;


public interface ChildService {

    ChildDTO save(ChildDTO childDTO);
    List<ChildDTO> getAllChild();
    ChildDTO createChild(ChildDTO childDTO);
    Child getChild(UUID id);

}

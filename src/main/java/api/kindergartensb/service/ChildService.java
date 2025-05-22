package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;


import java.util.List;


public interface ChildService {
    ChildDTO save(ChildDTO childDTO);
    List<ChildDTO> getAllChild();

    ChildDTO createChild(ChildDTO childDTO);
}

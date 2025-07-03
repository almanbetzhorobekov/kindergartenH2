package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;

import java.util.UUID;

public interface ChildWriteService {

    ChildDTO create(ChildDTO childDTO);
    ChildDTO updateChild(UUID id,ChildDTO childDTO);
    void deleteChild(UUID id);

}

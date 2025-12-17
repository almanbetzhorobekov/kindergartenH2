package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;

import java.util.UUID;

public interface ChildWriteService {

    ChildDTO create(ChildDTO childDTO);
    ChildDTO updateChild(UUID uuid,ChildDTO childDTO);
    void deleteChild(UUID uuid);
    void deactivateChild(UUID uuid);
    ChildDTO changeGroup(UUID uuid, UUID newGroupId);

}

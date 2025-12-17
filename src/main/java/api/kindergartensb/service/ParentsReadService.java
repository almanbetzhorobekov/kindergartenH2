package api.kindergartensb.service;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ParentsDTO;

import java.util.List;
import java.util.UUID;

public interface ParentsReadService {

    ParentsDTO getParentsById(UUID uuid);
    AddressDTO getAddressByParentId(UUID parentId);
    List<ParentsDTO> getAllParents();
    // List<ParentsDTO> getParentsByChildId(UUID childId);
}

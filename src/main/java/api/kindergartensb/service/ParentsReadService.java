package api.kindergartensb.service;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ParentsDTO;

import java.util.UUID;

public interface ParentsReadService {

    ParentsDTO getParentsById(UUID id);
    AddressDTO getAddressByParentId(UUID parentId);

}

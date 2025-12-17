package api.kindergartensb.service;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.ParentsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ParentsReadService {

    ParentsDTO getParentsById(UUID uuid);
    AddressDTO getAddressByParentId(UUID parentId);
    Page<ParentsDTO> getAllParents(Pageable pageable);
}

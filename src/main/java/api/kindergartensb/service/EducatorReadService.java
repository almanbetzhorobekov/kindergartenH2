package api.kindergartensb.service;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.EducatorMiniDTO;
import api.kindergartensb.dto.GroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EducatorReadService {

    EducatorDTO getEducatorById(UUID uuid);
    Optional<GroupDTO> getGroupById(UUID uuid);
    List<GroupDTO> getGroups();
    AddressDTO getAddress();
    List<EducatorDTO> getAll();
    Page<EducatorMiniDTO> getInfo(Pageable pageable);

}

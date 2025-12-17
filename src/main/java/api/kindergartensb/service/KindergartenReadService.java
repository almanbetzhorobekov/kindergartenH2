package api.kindergartensb.service;

import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.dto.KindergartenMiniDto;

import java.util.List;
import java.util.UUID;

public interface KindergartenReadService {

    KindergartenDTO getById(UUID uuid);
    List<KindergartenDTO> getAll();
    List<KindergartenMiniDto> getAllMiniDto();
    KindergartenDTO findWithGroupsByUuid(UUID uuid);

}

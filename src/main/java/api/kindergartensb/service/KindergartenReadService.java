package api.kindergartensb.service;

import api.kindergartensb.dto.KindergartenDTO;

import java.util.List;
import java.util.UUID;

public interface KindergartenReadService {

    KindergartenDTO getById(UUID id);
    List<KindergartenDTO> getAll();

}

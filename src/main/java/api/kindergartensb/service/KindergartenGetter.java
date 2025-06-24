package api.kindergartensb.service;

import api.kindergartensb.dto.KindergartenDTO;

import java.util.List;
import java.util.UUID;

public interface KindergartenGetter {
    KindergartenDTO getById(UUID id);
    KindergartenDTO getOne();
    List<KindergartenDTO> getAll();
}

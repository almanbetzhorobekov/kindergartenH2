package api.kindergartensb.service;

import api.kindergartensb.dto.KindergartenDTO;

import java.util.UUID;


public interface KindergartenWriteService {

    KindergartenDTO create(KindergartenDTO dto);
    void delete(UUID id);
    KindergartenDTO update(UUID id, KindergartenDTO dto);

}

package api.kindergartensb.service;

import api.kindergartensb.dto.ParentsDTO;

import java.util.UUID;

public interface ParentsWriteService {

    ParentsDTO create(ParentsDTO parentsDTO);
    ParentsDTO update(UUID id, ParentsDTO parentsDTO);
    void delete(UUID id);
}

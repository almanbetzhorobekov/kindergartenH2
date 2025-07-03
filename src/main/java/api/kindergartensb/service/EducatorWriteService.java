package api.kindergartensb.service;

import api.kindergartensb.dto.EducatorDTO;

import java.util.UUID;

public interface EducatorWriteService {

    EducatorDTO create(EducatorDTO educatorDTO);
    void delete(UUID id);
    EducatorDTO update(UUID id, EducatorDTO educatorDTO);
}

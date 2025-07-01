package api.kindergartensb.service;

import api.kindergartensb.dto.GroupDTO;

import java.util.List;
import java.util.UUID;

public interface GroupReadService {
    GroupDTO getById(UUID id);
    List<GroupDTO> getAll();


}


package api.kindergartensb.service;

import api.kindergartensb.dto.GroupDTO;

import java.util.List;
import java.util.UUID;

public interface GroupReadService {
    GroupDTO getById(UUID uuid);
    List<GroupDTO> getAll();
    List<GroupDTO> getGroupsByKindergartenId(UUID kindergartenId);
}


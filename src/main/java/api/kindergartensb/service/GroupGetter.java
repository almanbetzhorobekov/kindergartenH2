package api.kindergartensb.service;

import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;

import java.util.List;
import java.util.UUID;

public interface GroupGetter {
    GroupDTO getById(UUID id);
    List<GroupDTO> getAll();
    int getGroupCount();
}

package api.kindergartensb.service;

import api.kindergartensb.dto.GroupDTO;

import java.util.UUID;


public interface GroupWriteService {

    GroupDTO create(GroupDTO dto);
    GroupDTO update(UUID uuid, GroupDTO dto);
    void delete(UUID uuid);

}
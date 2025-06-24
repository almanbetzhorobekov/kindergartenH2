package api.kindergartensb.service;

import api.kindergartensb.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    GroupDTO create(GroupDTO dto);

    List<GroupDTO> getAll();

    int getGroupCount();

}
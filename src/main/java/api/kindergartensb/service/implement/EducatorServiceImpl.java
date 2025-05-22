package api.kindergartensb.service.implement;

import api.kindergartensb.assembler.EducatorAssembler;
import api.kindergartensb.dto.EducatorDTO;
import api.kindergartensb.dto.GroupDTO;
import api.kindergartensb.dto.KindergartenDTO;
import api.kindergartensb.repository.EducatorRepository;
import api.kindergartensb.service.EducatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EducatorServiceImpl implements EducatorService {

    public EducatorServiceImpl(EducatorRepository educatorRepository, EducatorAssembler educatorAssembler) {

    }

    @Override
    public void assignGroupToEducator(EducatorDTO educatorDTO, GroupDTO groupDTO) {
        if (educatorDTO.getGroupDTOList() == null) {
            educatorDTO.setGroupDTOList(new ArrayList<>());
        }
        educatorDTO.getGroupDTOList().add(groupDTO);

    }

    @Override
    public void assignKindergartenToEducator(EducatorDTO educatorDTO, KindergartenDTO kindergartenDTO) {
        educatorDTO.setKindergartenDTO(kindergartenDTO);
    }
}

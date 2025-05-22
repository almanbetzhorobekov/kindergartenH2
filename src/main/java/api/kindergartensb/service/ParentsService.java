package api.kindergartensb.service;

import api.kindergartensb.dto.ChildDTO;
import org.springframework.stereotype.Service;

@Service
public interface ParentsService {
    void addChild(ChildDTO childDTO);
    void removeChild(ChildDTO childDTO);
    void childName(ChildDTO childDTO);
}

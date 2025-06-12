package api.kindergartensb.controller;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping()
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable UUID id,
                                                    @RequestBody AddressDTO dto) {
        return ResponseEntity.ok(addressService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressDTO> deleteAddress(@PathVariable UUID id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

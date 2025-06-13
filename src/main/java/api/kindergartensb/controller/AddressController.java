package api.kindergartensb.controller;

import api.kindergartensb.dto.AddressDTO;
import api.kindergartensb.service.AddressService;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO dto) {
        return ResponseEntity.ok(addressService.create(dto));
    }

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
                                                    @RequestBody @Valid AddressDTO dto) {

        // 1. Schritt
        System.out.println("updateAddress");

        // 2. Schritt: Validierung AddressDTO (@Valid)

        // 3. Schritt: Service aufrufen
        return ResponseEntity.ok(addressService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressDTO> deleteAddress(@PathVariable UUID id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();//200 status code
        //400 not found
    }
}

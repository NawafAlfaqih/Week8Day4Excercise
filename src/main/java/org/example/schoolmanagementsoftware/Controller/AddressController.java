package org.example.schoolmanagementsoftware.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiResponse;
import org.example.schoolmanagementsoftware.DTO.AddressDTO;
import org.example.schoolmanagementsoftware.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Address added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateAddress(id, addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Address deleted successfully"));
    }
}

package org.example.schoolmanagementsoftware.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotBlank(message = "area cannot be empty")
    @Size(min = 3, message = "area's length must be at least '3' letters.")
    private String area;

    @NotBlank(message = "area cannot be empty")
    @Size(min = 3, message = "street's length must be at least '3' letters.")
    private String street;

    @NotBlank(message = "building number cannot be empty")
    @Size(min = 3, message = "building number's length must be at least '3' letters.")
    private String buildingNumber;
}

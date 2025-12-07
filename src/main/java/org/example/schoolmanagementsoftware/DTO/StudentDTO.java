package org.example.schoolmanagementsoftware.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {

    private String name;
    private Integer age;
    private String major;
}

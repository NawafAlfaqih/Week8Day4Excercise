package org.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name cannot be empty.")
    @Size(min = 3, message = "name must be at least '3' in length.")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "age cannot be null.")
    @Positive(message = "age must be a positive number.")
    @Min(value = 23, message = "age must be at least '23'.")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotBlank(message = "email cannot be empty.")
    @Email
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotNull(message = "salary cannot be null.")
    @Positive(message = "salary must be a positive number.")
    @Min(value = 5000, message = "salary must be at least '5000.0'. ")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}

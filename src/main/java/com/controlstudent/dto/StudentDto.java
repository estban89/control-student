package com.controlstudent.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 80)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String dni;
    @NotNull
    private Integer age;
}

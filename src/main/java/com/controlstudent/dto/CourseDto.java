package com.controlstudent.dto;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.*;
import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String acronym;
    @NotNull
    private Boolean state;
}

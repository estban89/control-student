package com.controlstudent.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TuitionDetailDto {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String classroom;
    @NotNull
    private CourseDto course;
    @JsonBackReference
    private TuitionDto tuition;

}

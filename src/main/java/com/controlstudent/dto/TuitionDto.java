package com.controlstudent.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TuitionDto {


    private Long id;

    @NotNull
    private LocalDateTime date;
    @NotNull
    private Boolean state;
    @NotNull
    private StudentDto student;
    @NotNull
    @JsonManagedReference
    private List<TuitionDetailDto> details;

}

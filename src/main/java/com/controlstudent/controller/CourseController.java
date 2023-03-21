package com.controlstudent.controller;

import com.controlstudent.dto.CourseDto;
import com.controlstudent.exception.ModelNotFoundException;
import com.controlstudent.model.Course;
import com.controlstudent.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    @Qualifier("courseMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<CourseDto> create(@Valid @RequestBody CourseDto dto) throws Exception {
        Course obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseDto dto) throws Exception {
        Course obj = service.readById(dto.getId());

        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }

        Course cat = service.update(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(cat), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        Course obj = service.readById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CourseDto convertToDto(Course obj) {
        return mapper.map(obj, CourseDto.class);
    }

    private Course convertToEntity(CourseDto dto) {
        return mapper.map(dto, Course.class);
    }

}

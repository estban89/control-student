package com.controlstudent.controller;

import com.controlstudent.dto.StudentDto;
import com.controlstudent.exception.ModelNotFoundException;
import com.controlstudent.model.Student;
import com.controlstudent.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @Qualifier("studentMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto dto) throws Exception {
        Student obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentDto> update(@Valid @RequestBody StudentDto dto) throws Exception {
        Student obj = service.readById(dto.getId());

        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }

        Student cat = service.update(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(cat), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        Student obj = service.readById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/orderStudent")
    public ResponseEntity<List<StudentDto>> findAllOrder(){
        List<StudentDto> lst = service.findAllOrder().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    private StudentDto convertToDto(Student obj) {
        return mapper.map(obj, StudentDto.class);
    }

    private Student convertToEntity(StudentDto dto) {
        return mapper.map(dto, Student.class);
    }

}

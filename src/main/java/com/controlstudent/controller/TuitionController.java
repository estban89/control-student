package com.controlstudent.controller;

import com.controlstudent.dto.StudentDto;
import com.controlstudent.dto.TuitionDto;
import com.controlstudent.exception.ModelNotFoundException;
import com.controlstudent.model.Tuition;
import com.controlstudent.service.ITuitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tuition")
@RequiredArgsConstructor
public class TuitionController {

    private final ITuitionService service;

    @Qualifier("tuitionMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<TuitionDto> create(@Valid @RequestBody TuitionDto dto) throws Exception{
        Tuition obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TuitionDto> update(@Valid @RequestBody TuitionDto dto) throws Exception{
        Tuition obj = service.readById(dto.getId());

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }

        Tuition sale = service.update(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(sale), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Tuition obj = service.readById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/courses")
    public ResponseEntity<Map<String, List<String>>> getEnrolledCourses(){
        Map<String, List<String>> map = service.getEnrolledCourses();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    private TuitionDto convertToDto(Tuition obj) {
        return mapper.map(obj, TuitionDto.class);
    }

    private Tuition convertToEntity(TuitionDto dto){
        return mapper.map(dto, Tuition.class);
    }

}

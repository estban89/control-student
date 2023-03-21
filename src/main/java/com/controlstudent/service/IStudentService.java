package com.controlstudent.service;

import com.controlstudent.dto.StudentDto;
import com.controlstudent.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Long> {

    List<Student> findAllOrder();

}

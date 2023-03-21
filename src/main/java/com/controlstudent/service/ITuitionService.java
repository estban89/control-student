package com.controlstudent.service;

import com.controlstudent.model.Tuition;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITuitionService extends ICRUD<Tuition,Long> {

    Map<String, List<String>> getEnrolledCourses();
}

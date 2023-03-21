package com.controlstudent.service.Impl;

import com.controlstudent.model.Course;
import com.controlstudent.repo.*;
import com.controlstudent.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Long> implements ICourseService {

    private final ICourseRepo repo;
    @Override
    protected IGenericRepo<Course, Long> getRepo() {
        return repo;
    }
}

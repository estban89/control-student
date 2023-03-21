package com.controlstudent.service.Impl;

import com.controlstudent.model.Student;
import com.controlstudent.repo.IGenericRepo;
import com.controlstudent.repo.IStudentRepo;
import com.controlstudent.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Long> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Long> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findAllOrder() {
        Sort.Direction direction = Sort.Direction.DESC;
        return repo.findAll(Sort.by(direction, "age"));
    }
}

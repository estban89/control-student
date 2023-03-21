package com.controlstudent.service.Impl;

import com.controlstudent.model.Tuition;
import com.controlstudent.model.TuitionDetail;
import com.controlstudent.repo.IGenericRepo;
import com.controlstudent.repo.ITuitionRepo;
import com.controlstudent.service.ITuitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class TuitionServiceImpl extends CRUDImpl<Tuition,Long> implements ITuitionService {

    private final ITuitionRepo repo;

    @Override
    protected IGenericRepo<Tuition, Long> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getEnrolledCourses() {
        Stream<List<TuitionDetail>> stream = repo.findAll().stream().map(Tuition::getDetails);
        Stream<TuitionDetail> streamDetail = stream.flatMap(Collection::stream);

        Map<String, List<String>> byCourses = streamDetail
                .collect(groupingBy(d -> d.getCourse().getName(),mapping(d-> d.getTuition().getStudent().getName(),Collectors.toList())));

        return byCourses.entrySet()
                .stream()
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }



}

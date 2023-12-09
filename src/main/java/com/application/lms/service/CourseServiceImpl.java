package com.application.lms.service;

import com.application.lms.controller.CourseRegistrationRequest;
import com.application.lms.domain.Course;
import com.application.lms.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl {
    private final CourseRepository repository;

    public List<Course> courseList() {
        return repository.findAll();
    }

    public Course createCourse(CourseRegistrationRequest request) {
        var course = Course.builder()
                .courseTitle(request.getCourseTitle())
                .subject(request.getSubject())
                .author(request.getAuthor())
                .build();
        return repository.save(course);
    }
}

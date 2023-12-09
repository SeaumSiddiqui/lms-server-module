package com.application.lms.service;

import com.application.lms.controller.CourseRegistrationRequest;
import com.application.lms.domain.Course;
import com.application.lms.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
                .author(request.getAuthor())
                .build();
        return repository.save(course);
    }

    public Course getCourseById(Long id) {
        return repository.findById(id).orElseThrow(()-> new UsernameNotFoundException("add appropriate error"));
    }

    public Course updateCourse(Course course, Long id) {
        return repository.findById(id).map(co->{
            co.setCourseTitle(course.getCourseTitle());
            co.setAuthor(course.getAuthor());
            return repository.save(co);
        }).orElseThrow(()-> new UsernameNotFoundException("add appropriate error"));
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}

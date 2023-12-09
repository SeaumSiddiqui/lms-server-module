package com.application.lms.controller;

import com.application.lms.domain.Course;
import com.application.lms.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Course>> courseList() {
        return ResponseEntity.ok(service.courseList());
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseRegistrationRequest request) {
        return ResponseEntity.ok(service.createCourse(request));
    }
}

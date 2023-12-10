package com.application.lms.controller;

import com.application.lms.domain.Course;
import com.application.lms.domain.Lecture;
import com.application.lms.domain.User;
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
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(service.createCourse(course));
    }

    @GetMapping("/id-{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCourseById(id));
    }

    @PutMapping("/update-{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateCourse(course, id));
    }

    @DeleteMapping("/delete-{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<User>> studentsEnrolled(@PathVariable Long id) {
        Course course = service.getCourseById(id);
        return ResponseEntity.ok(course.getStudents());
    }

    @GetMapping("/{id}/lectures")
    public ResponseEntity<List<Lecture>> lecturesUploaded(@PathVariable Long id) {
        Course course = service.getCourseById(id);
        return ResponseEntity.ok(course.getLectures());
    }
}

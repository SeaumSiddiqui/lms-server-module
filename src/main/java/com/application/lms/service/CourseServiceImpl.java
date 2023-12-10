package com.application.lms.service;

import com.application.lms.domain.Course;
import com.application.lms.exception.CourseNotFoundException;
import com.application.lms.exception.NameAlreadyTakenException;
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

    public Course createCourse(Course course) {
        if (nameNotAvailable(course.getCourseTitle())) {
            throw new NameAlreadyTakenException("Title: " + course.getCourseTitle() + " already exists in the server");
        }
        return repository.save(course);
    }

    public Course getCourseById(Long id) {
        return repository.findById(id).orElseThrow(()-> new CourseNotFoundException("No course found"));
    }

    public Course updateCourse(Course course, Long id) {
        return repository.findById(id).map(co->{
            co.setCourseTitle(course.getCourseTitle());
            co.setAuthor(course.getAuthor());
            return repository.save(co);
        }).orElseThrow(()-> new CourseNotFoundException("Couldn't find course with the title: " + course.getCourseTitle() + " to update "));
    }

    public void deleteCourse(Long id) {
        if (!repository.existsById(id)) {
            throw new CourseNotFoundException("Unable to delete course");
        }
        repository.deleteById(id);
    }


    private boolean nameNotAvailable(String title) {
        return repository.findByCourseTitle(title).isPresent();
    }
}

package com.application.lms.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String courseName;

    @JoinColumn(name = "teacher_id")
    private User teacher;

    @ManyToMany(mappedBy = "coursesEnrolled")
    private List<User> students;
    @OneToMany(mappedBy = "course")
    private List<Lecture> lectures;
}

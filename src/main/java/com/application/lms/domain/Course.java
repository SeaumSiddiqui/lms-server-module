package com.application.lms.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String courseTitle;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User author;

    @ManyToMany(mappedBy = "coursesEnrolled")
    private List<User> students;
    @OneToMany(mappedBy = "course")
    private List<Lecture> lectures;
}

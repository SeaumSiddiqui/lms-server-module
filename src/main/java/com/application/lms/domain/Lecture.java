package com.application.lms.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lecture {
    @Id
    @GeneratedValue
    private Long id;
    private String lectureTitle;
    private String Url;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}

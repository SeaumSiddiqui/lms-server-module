package com.application.lms.controller;

import com.application.lms.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationRequest {
    private String courseTitle;
    private String subject;
    private User author;
}

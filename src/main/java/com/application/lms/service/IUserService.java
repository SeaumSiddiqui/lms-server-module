package com.application.lms.service;

import com.application.lms.controller.UserRegistrationRequest;
import com.application.lms.domain.Course;
import com.application.lms.domain.User;
import com.application.lms.domain.UserRole;

import java.util.List;

public interface IUserService {
    List<User> userList();
    User createUser(UserRegistrationRequest request);
    User getUserById(Long id);
    User updateUser(User user, Long id);
    void deleteUser(Long id);
    List<User> getUsersByRole(UserRole role);
}

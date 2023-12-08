package com.application.lms.service;

import com.application.lms.controller.RegistrationRequest;
import com.application.lms.domain.User;
import com.application.lms.domain.UserRole;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    List<User> getUsersByRole(UserRole role);
    User addUser(RegistrationRequest request);
    User getUserById(Long id);
    User updateUser(User user, Long id);
    void deleteUser(Long id);

}

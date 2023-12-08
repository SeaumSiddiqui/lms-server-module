package com.application.lms.repository;

import com.application.lms.domain.User;
import com.application.lms.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(UserRole role);
}

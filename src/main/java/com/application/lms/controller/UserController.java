package com.application.lms.controller;

import com.application.lms.domain.Course;
import com.application.lms.domain.User;
import com.application.lms.domain.UserRole;
import com.application.lms.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    @GetMapping
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(service.userList());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    @GetMapping("/id-{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/update-{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateUser(user, id));
    }

    @DeleteMapping("/delete-{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        return ResponseEntity.ok(service.getUsersByRole(userRole));
    }

    @GetMapping("/{id}/enrolled")
    public ResponseEntity<List<Course>> coursesEnrolled(@PathVariable Long id) {
        User student = service.getUserById(id);
        return ResponseEntity.ok(student.getCoursesEnrolled());

    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> coursesCreated(@PathVariable Long id) {
        User student = service.getUserById(id);
        return ResponseEntity.ok(student.getCoursesCreated());
    }

}

package com.application.lms.controller;

import com.application.lms.domain.User;
import com.application.lms.domain.UserRole;
import com.application.lms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        return ResponseEntity.ok(service.getUsersByRole(userRole));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(service.addUser(request));
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
}

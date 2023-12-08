package com.application.lms.service;

import com.application.lms.controller.RegistrationRequest;
import com.application.lms.domain.User;
import com.application.lms.domain.UserRole;
import com.application.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public List<User> getUsersByRole(UserRole role) {
        return repository.findByRole(role);
    }

    @Override
    public User addUser(RegistrationRequest request) { // --TODO
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .department(request.getDepartment())
                .role(request.getRole())
                .build();
        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find the user"));
    }

    @Override
    public User updateUser(User user, Long id) {
        return repository.findById(id).map(st -> {
            st.setFirstname(user.getFirstname());
            st.setLastname(user.getLastname());
            st.setEmail(user.getEmail());
            st.setPassword(user.getPassword()); // --TODO
            st.setDepartment(user.getDepartment());
            st.setRole(user.getRole());
            return repository.save(st);
        }).orElseThrow(() -> new UsernameNotFoundException("Could not find user to update"));
    }

    @Override
    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        repository.deleteById(id);
    }
}

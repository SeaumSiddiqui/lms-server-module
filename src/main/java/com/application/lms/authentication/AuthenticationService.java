package com.application.lms.authentication;

import com.application.lms.configuration.JwtService;
import com.application.lms.domain.User;
import com.application.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegistrationRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .department(request.getDepartment())
                .role(request.getRole())
                .build();
        repository.save(user);
        var userToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(userToken).build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User Not found by email: " + request.getEmail()));
        var userToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(userToken).build();
    }
}

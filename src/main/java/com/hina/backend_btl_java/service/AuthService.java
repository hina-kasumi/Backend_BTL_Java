package com.hina.backend_btl_java.service;

import com.hina.backend_btl_java.dto.request.LoginRequest;
import com.hina.backend_btl_java.dto.request.RegisterRequest;
import com.hina.backend_btl_java.dto.response.LoginResponse;
import com.hina.backend_btl_java.entity.User;
import com.hina.backend_btl_java.exception.AppException;
import com.hina.backend_btl_java.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public int login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new AppException(400, "username not found");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new AppException(400, "wrong password");
        }

        return user.getCoin();
    }

    public void register(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .coin(registerRequest.getCoin())
                .build();

        userRepository.save(user);
    }
}

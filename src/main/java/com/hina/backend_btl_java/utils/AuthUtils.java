package com.hina.backend_btl_java.utils;

import com.hina.backend_btl_java.entity.User;
import com.hina.backend_btl_java.exception.AppException;
import com.hina.backend_btl_java.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class AuthUtils {
    UserRepository userRepository;

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new AppException(400, "username not found");
        }

        return user;
    }
}

package com.example.springmusicapp.service;

import com.example.springmusicapp.entity.User;
import com.example.springmusicapp.form.UserForm;
import com.example.springmusicapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserForm userForm) {
        User user = new User();
        user.setUsername(userForm.getUsername());

        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);

        userRepository.insertUser(user);
    }
}

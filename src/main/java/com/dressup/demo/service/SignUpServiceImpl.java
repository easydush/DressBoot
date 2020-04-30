package com.dressup.demo.service;


import com.dressup.demo.dto.SignUpDto;
import com.dressup.demo.models.Role;
import com.dressup.demo.models.State;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Component
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto form) {
        User user = User
                .builder()
                .username(form.getUsername())
                .fullName(form.getFullName())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(Role.USER)
                .state(State.CONFIRMED)
                .build();
        userRepository.save(user);
    }
}
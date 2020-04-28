package com.dressup.demo.service;


import java.util.List;
import java.util.Set;
import javax.persistence.EntityNotFoundException;

import com.dressup.demo.dto.SignUpDto;
import com.dressup.demo.dto.UserDto;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public interface UserService {

    List<UserDto> getAllUsers(Integer page, Integer size, String sort);

    List<UserDto> getAllUsers();

    UserDto getUser(Long userId);

    void deleteUser(Long userId);

    UserDto addUser(SignUpDto userData);

    User getUserByUsername(String username);


}
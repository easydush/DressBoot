package com.dressup.demo.service;

import com.dressup.demo.dto.SignUpDto;
import com.dressup.demo.dto.UserDto;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.Role;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers(Integer page, Integer size, String property) {
        Sort sort = Sort.by(property);
        PageRequest request = PageRequest.of(page, size, sort);
        Page<User> pageResult = userRepository.findAll(request);
        List<User> users = pageResult.getContent();
        return UserDto.from(users);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserDto.from(users);
    }


    @Override
    public UserDto getUser(Long userId) {
        return UserDto.from(userRepository.getOne(userId));
    }


    @Override
    public UserDto addUser(SignUpDto userData) {
        User user = User
                .builder()
                .username(userData.getUsername())
                .fullName(userData.getFullName())
                .hashPassword(userData.getPassword())
                .role(Role.USER)
                .looks(new ArrayList<Look>())
                .items(new ArrayList<Item>())
                .build();

        userRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Cant find User");
    }
}
package com.dressup.demo.service;


import java.util.Set;
import javax.persistence.EntityNotFoundException;

import com.dressup.demo.models.User;
import com.dressup.demo.models.UserAuthority;
import com.dressup.demo.repositories.UserAuthorityRepository;
import com.dressup.demo.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserAuthorityRepository userAuthorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(final String nickname) throws UsernameNotFoundException {
        return userRepo.findByNickname(nickname);
    }

    public void registerUser(User user) {
        if(userRepo.findByNickname(user.getNickname()) != null){
            throw new DuplicateKeyException("Duplicate key - username field.");
        }
        user.setAuthorities((Set<UserAuthority>) userAuthorityRepo.findByAuthority("ROLE_USER"));
        user.setHashPassword(passwordEncoder.encode(user.getHashPassword()));
        user.setPasswordRepeat(user.getHashPassword());
        userRepo.save(user);
    }

    public User updateFullNameAndAuthorities(Integer id, String fullName, Set<UserAuthority> authorities) {
        try {
            User user = userRepo.findById(id).get();
            user.setPasswordRepeat(user.getHashPassword());
            user.setFullName(fullName);
            user.setAuthorities(authorities);
            return user;
        } catch (NoSuchElementException ex) {
            throw new EntityNotFoundException("User with id " + id + "has not been found.");
        }
    }

}
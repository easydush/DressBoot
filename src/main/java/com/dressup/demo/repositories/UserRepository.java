package com.dressup.demo.repositories;

import com.dressup.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    UserDetails findByNickname(String nickname);
}

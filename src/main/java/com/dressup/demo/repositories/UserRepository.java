package com.dressup.demo.repositories;

import com.dressup.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    boolean existsUserByUsername(String username);
    User findUserById(long id);
    Integer countUsers();
}

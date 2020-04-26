package com.dressup.demo.repositories;

import com.dressup.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByNickname(String nickname);
    boolean existsUserByNickname(String nickname);
    boolean existsUserByEmail(String email);
    User findUserById(long id);
    Integer countUsers();
}

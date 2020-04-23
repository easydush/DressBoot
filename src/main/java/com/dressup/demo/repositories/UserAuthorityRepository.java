package com.dressup.demo.repositories;

import com.dressup.demo.models.UserAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {
    Object findByAuthority(String role_user);
}

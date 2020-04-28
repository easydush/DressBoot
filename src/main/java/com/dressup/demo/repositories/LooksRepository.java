package com.dressup.demo.repositories;

import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LooksRepository extends JpaRepository<Look, Long> {
    List<Look> findAllByUser(User user);
    List<Look> findAllByItems(Item item);
    Optional<Look> findByName(String name);
    Optional<Look> findById(long id);

    List<Look> findAllByOwner(User owner);
}

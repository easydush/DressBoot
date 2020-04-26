package com.dressup.demo.repositories;

import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LooksRepository extends CrudRepository<Look, Integer> {
    List<Look> findAllByUser(User user);
    List<Look> findAllByItems(Item item);
    Integer countAll();
    Look findByName(String name);
    Look findById(long id);
}

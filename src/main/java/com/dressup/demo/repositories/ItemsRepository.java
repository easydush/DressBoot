package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByBrand(Brand brand);
    List<Item> findAllByLooks(Look look);
    List<Item> findAllByOwner(User owner);
    Optional<Item> findById(long id);
}

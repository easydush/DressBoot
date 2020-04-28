package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByBrand(Brand brand);
    List<Item> findAllByLooks(Look look);
    Optional<Item> findById(long id);
}

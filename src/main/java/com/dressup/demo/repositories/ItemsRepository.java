package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepository extends CrudRepository<Item, Integer> {
    List<Item> findAllByBrand(Brand brand);
    List<Item> findAllByLooks(Look look);
    Optional<Item> findById(long id);
}

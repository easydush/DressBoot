package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ItemsRepository extends CrudRepository<Item, Integer> {
    ArrayList<Item> findAllByBrand(Optional<Brand> brand);
}

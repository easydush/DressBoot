package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Optional<Brand> findBrandById(Integer id);
    Optional<Brand> findBrandByName(String name);
}

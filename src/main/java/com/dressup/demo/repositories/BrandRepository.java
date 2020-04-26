package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findBrandById(Integer id);
    Integer countAll();
    Brand findBrandByName(String name);
}

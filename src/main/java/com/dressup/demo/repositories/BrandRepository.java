package com.dressup.demo.repositories;

import com.dressup.demo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findBrandById(Integer id);
    Optional<Brand> findBrandByName(String name);
    List<Brand> findAll();
}

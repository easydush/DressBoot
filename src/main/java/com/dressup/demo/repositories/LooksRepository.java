package com.dressup.demo.repositories;

import com.dressup.demo.models.Look;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LooksRepository extends CrudRepository<Look, Integer> {
}

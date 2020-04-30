package com.dressup.demo.service;


import com.dressup.demo.dto.CreateLookDto;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.LooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CreateLookServiceImpl implements CreateLookService {

    @Autowired
    private LooksRepository looksRepository;

    @Override
    public void createLook(CreateLookDto createLookDto, User owner) {
        Look look = Look
                .builder()
                .id(createLookDto.getId())
                .owner(owner)
                .description(createLookDto.getDescription())
                .items(new ArrayList<Item>())
                .build();
        looksRepository.save(look);
    }
}
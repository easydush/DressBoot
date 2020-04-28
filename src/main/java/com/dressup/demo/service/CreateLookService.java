package com.dressup.demo.service;

import com.dressup.demo.dto.CreateLookDto;
import com.dressup.demo.models.User;

public interface CreateLookService {
    void createLook(CreateLookDto createLookDto, User owner);
}

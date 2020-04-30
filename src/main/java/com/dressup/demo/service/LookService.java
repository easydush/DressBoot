package com.dressup.demo.service;

import com.dressup.demo.dto.LookDto;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;

import java.util.List;

public interface LookService {
    List<Look> getAllLooks();

    Look getLook(Long id);

    Look addLook(LookDto lookData, User owner);

    List<Look> getUsersAllLooks(User owner);

}

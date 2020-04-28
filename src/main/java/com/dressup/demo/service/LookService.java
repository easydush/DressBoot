package com.dressup.demo.service;

import com.dressup.demo.dto.LookDto;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;

import java.util.List;

public interface LookService {
    List<Look> getAllLooks(Integer page, Integer size, String sort);

    Look getLook(Long tweetId);

    Look addLook(LookDto lookData, User owner);

    List<Look> getUsersAllLooks(User owner);

}

package com.dressup.demo.service;

import com.dressup.demo.dto.LookDto;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.LooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LookServiceImpl implements LookService {
    @Autowired
    private LooksRepository looksRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Look> getAllLooks(Integer page, Integer size, String property) {
        return null;
    }

    @Override
    public Look addLook(LookDto lookDto, User owner) {
        Look look  = Look
                .builder()
                .description(lookDto.getDescription())
                .owner(owner)
                .id(lookDto.getId())
                .items(new ArrayList<Item>())
                .build();
        looksRepository.save(look);
        return look;
    }



    @Override
    public Look getLook(Long lookId) {
        return looksRepository.getOne(lookId);
    }


    @Override
    public List<Look> getUsersAllLooks(User owner) {
        List<Look> looks = looksRepository.findAllByOwner(owner);
        return looks;
    }

}

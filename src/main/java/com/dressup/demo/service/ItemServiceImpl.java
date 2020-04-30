package com.dressup.demo.service;

import com.dressup.demo.dto.ItemDto;
import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.BrandRepository;
import com.dressup.demo.repositories.ItemsRepository;
import com.dressup.demo.repositories.LooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemServiceImpl implements ItemService {
    @Autowired
    private LooksRepository looksRepository;
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Item> getAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public Item addItem(ItemDto itemDto, User owner, String brand_name) {
        Item item  = Item
                .builder()
                .description(itemDto.getDescription())
                .owner(owner)
                .id(itemDto.getId())
                .looks(new ArrayList<Look>())
                .brand(brandRepository.findBrandByName(brand_name).get())
                .image_url(itemDto.getImage_url())
                .build();
        itemsRepository.save(item);
        return item;
    }
    @Override
    public Item addItem(ItemDto itemDto, User owner, String brand_name, Long look_id) {
        ArrayList<Look> newLooks = new ArrayList<>();
        newLooks.add(looksRepository.findById(look_id).get());
        Item item  = Item
                .builder()
                .name(itemDto.getName())
                .description(itemDto.getDescription())
                .owner(owner)
                .id(itemDto.getId())
                .looks(newLooks)
                .brand(brandRepository.findBrandByName(brand_name).get())
                .image_url(itemDto.getImage_url())
                .build();
        itemsRepository.save(item);
        return item;
    }



    @Override
    public Item getItem(Long itemId) {
        return itemsRepository.getOne(itemId);
    }


    @Override
    public List<Item> getUsersAllItems(User owner) {
        List<Item> items = itemsRepository.findAllByOwner(owner);
        return items;
    }


}

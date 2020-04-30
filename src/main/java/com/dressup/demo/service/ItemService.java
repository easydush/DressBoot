package com.dressup.demo.service;

import com.dressup.demo.dto.ItemDto;
import com.dressup.demo.dto.LookDto;
import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

   Item getItem(Long id);

    Item addItem(ItemDto itemData, User owner, String brand_name);
    Item addItem(ItemDto itemData, User owner, String brand_name, Long look_id);

    List<Item > getUsersAllItems(User owner);

}
package com.dressup.demo.controllers;

import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.BrandRepository;
import com.dressup.demo.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/items")
@ComponentScan(basePackages = {"com.dressup.demo.repositories"})
public class ItemsController {
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private BrandRepository brandsRepository;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Item> listItems(@RequestParam("brand_id") int brand_id) {
        List<Item> item_list = new ArrayList<>();
        item_list.add(new Item(0, "lookd", "the coolest look", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        System.out.println(item_list);
        return item_list;
    }

    @RequestMapping("/list")
    public String listAllItems(ModelMap map) {
        List<Item> item_list = new ArrayList<>();
        item_list.add(new Item(0, "lookd", "the coolest look", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(1, "loo", "second", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(2, "lookkk", "third", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(3, "lookd", "fourth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(4, "loo", "fifth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(5, "lookkk", "sixth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(6, "lookd", "eighth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(7, "loo", "ninth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(8, "lookkk", "tenth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(9, "lookd", "eleventh", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(10, "loo", "twelfth", new Brand(), new ArrayList<>(), new User(), "vk.com"));
        item_list.add(new Item(11, "lookkk", "thirteenth", new Brand(), new ArrayList<>(), new User(), "vk.com"));

        map.put("items",item_list);
        return "list";
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Item allItems() {
        /*List<Item> item_list = new ArrayList<>();
        item_list.add(new Item(0, "lookd", "the coolest look", null, null, null, "vk.com"));
        item_list.add(new Item(1, "loo", "second", null, null, null, "vk.com"));
        item_list.add(new Item(2, "lookkk", "third", null, null, null, "vk.com"));
        */

        return new Item(100, "the new one", "the neew loook", null, null, null, "vk.com");
    }
}

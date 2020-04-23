package com.dressup.demo.controllers;

import com.dressup.demo.models.Brand;
import com.dressup.demo.repositories.ItemsRepository;
import com.dressup.demo.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@ComponentScan(basePackages = {"com.dressup.demo.repositories"})
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @RequestMapping
    public String listBrands(ModelMap map) {
        map.put("brands", brandRepository.findAll());
        return "test";
    }


}

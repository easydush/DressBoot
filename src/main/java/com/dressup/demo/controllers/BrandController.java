package com.dressup.demo.controllers;

import com.dressup.demo.dto.BrandDto;
import com.dressup.demo.models.Brand;
import com.dressup.demo.repositories.ItemsRepository;
import com.dressup.demo.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/brands")
@ComponentScan(basePackages = {"com.dressup.demo.repositories"})
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ItemsRepository itemsRepository;


    @RequestMapping
    @PreAuthorize("permitAll()")
    public String listBrands(ModelMap map) {
        map.put("brands", brandRepository.findAll());
        return "list";
    }

    @RequestMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBrand(ModelMap map, @Valid @ModelAttribute("form") BrandDto form, BindingResult bindingResult) {
        map.put("brands", brandRepository.findAll());
        return "admin/create_brand";
    }

}

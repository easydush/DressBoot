package com.dressup.demo.controllers;

import com.dressup.demo.dto.BrandDto;
import com.dressup.demo.repositories.BrandRepository;
import com.dressup.demo.service.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/brands")
@ComponentScan(basePackages = {"com.dressup.demo.repositories"})
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandServiceImpl brandService;


    @RequestMapping
    @PreAuthorize("permitAll()")
    public String listBrands(ModelMap map) {
        map.put("brands", brandRepository.findAll());
        return "admin/list";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBrand(ModelMap map, @Valid @ModelAttribute("form") BrandDto form, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            brandService.addBrand(form);
            return "redirect:success/brand_created";
        } else {
            map.put("form", form);
            return "admin/create_brand";
        }
    }

    @RequestMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBrand(ModelMap map, @Valid @ModelAttribute("form") BrandDto form) {
        map.put("form", form);
        return "admin/create_brand";

    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return "success/brand_deleted";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String updateBrand(ModelMap map, @Valid @ModelAttribute("form") BrandDto form, BindingResult bindingResult, @PathVariable long id) {
        if (!bindingResult.hasErrors()) {
            brandService.updateBrand(form, id);
            return "success/brand_updated";
        } else {
            map.put("form", form);
            return "admin/update_brand";
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String updateBrand(ModelMap map, @Valid @ModelAttribute("form") BrandDto form) {
        map.put("form", form);
        return "admin/update_brand";
    }
}

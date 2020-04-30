package com.dressup.demo.controllers;


import com.dressup.demo.config.oauth.VkConnector;
import com.dressup.demo.dto.ItemDto;
import com.dressup.demo.dto.LookDto;
import com.dressup.demo.dto.SignUpDto;
import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.User;
import com.dressup.demo.repositories.BrandRepository;
import com.dressup.demo.repositories.ItemsRepository;
import com.dressup.demo.repositories.LooksRepository;
import com.dressup.demo.repositories.UserRepository;
import com.dressup.demo.service.ItemService;
import com.dressup.demo.service.LookService;
import com.dressup.demo.utils.RandomImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/profile")
@Controller
public class ProfileController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    LookService lookService;
    @Autowired
    ItemService itemService;
    @Autowired
    LooksRepository looksRepository;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    private VkConnector vkConnector;
    @Autowired
    private RandomImage image;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping
    public String profile(Principal principal, ModelMap map){
        User user = userRepository.findUserByUsername(principal.getName()).get();
        map.addAttribute("user", user);

        map.addAttribute("random_image_url", image.getImageURL());
        return "user/profile";
    }


    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/looks")
    public String show_looks(Principal principal, ModelMap map){
        User user = userRepository.findByUsername(principal.getName()).get();
        map.addAttribute("user",user);
        map.addAttribute("looks",looksRepository.findAllByOwner(user));
        return "user/user_looks";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/items")
    public String show_items(Principal principal, ModelMap map){
        User user = userRepository.findByUsername(principal.getName()).get();
        map.addAttribute("user",user);
        map.put("brands", brandRepository.findAll());
        map.addAttribute("items",itemsRepository.findAllByOwner(user));
        return "user/user_items";
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/looks/create")
    public String add_look(@Valid @ModelAttribute("form") LookDto form, BindingResult bindingResult,
                           Principal principal, ModelMap map){
        User user = userRepository.findByUsername(principal.getName()).get();
        map.addAttribute("user",user);
        /*
        List<Item> items = itemsRepository.findAllByOwner(user);
        map.addAttribute("items", items);
        if (!bindingResult.hasErrors()) {
            lookService.addLook(form, user);
            return "redirect:"+ MvcUriComponentsBuilder.fromMappingName("PC#show_looks").build();
        } else {*/
            map.addAttribute("form", form);
            return"user/add_look";
        /*}*/
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/items/create")
    public String add_item(@Valid @ModelAttribute("form") ItemDto form, BindingResult bindingResult,
                           Principal principal, ModelMap map) throws MalformedURLException {
       User user = userRepository.findByUsername(principal.getName()).get();
        map.addAttribute("user",user);
        /*
        List<Item> items = itemsRepository.findAll();
        map.addAttribute("items", items);
        map.addAttribute("brands", brandRepository.findAll());
        map.addAttribute("vk_download",vkConnector.getLoginUrl());
        if (!bindingResult.hasErrors()) {
            itemService.addItem(form, user, brandRepository.findBrandByName((String) bindingResult.getFieldValue("brand_name")).get());
            return "redirect:"+ MvcUriComponentsBuilder.fromMappingName("PC#show_items").build();
        } else {*/
            map.addAttribute("form", form);
            return"user/add_item";
        //}
    }


}

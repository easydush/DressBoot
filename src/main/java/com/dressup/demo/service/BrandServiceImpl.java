package com.dressup.demo.service;


import com.dressup.demo.dto.BrandDto;
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
public class BrandServiceImpl implements BrandService {
   @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand addBrand(BrandDto brandDto) {
        Brand brand  = Brand
                .builder()
                .description(brandDto.getDescription())
                .id(brandDto.getId())
                .items(new ArrayList<Item>())
                .logoUrl(brandDto.getLogoUrl())
                .name(brandDto.getName())
                .build();
        brandRepository.save(brand);
        return brand;
    }
    @Override
    public Brand addBrand(BrandDto brandDto, Long id) {
        Brand brand  = Brand
                .builder()
                .description(brandDto.getDescription())
                .id(id)
                .items(new ArrayList<Item>())
                .logoUrl(brandDto.getLogoUrl())
                .name(brandDto.getName())
                .build();
        brandRepository.save(brand);
        return brand;
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void updateBrand(BrandDto brandData, Long id) {
        deleteBrand(id);
        addBrand(brandData, id);
    }


    @Override
    public Brand getBrand(Long itemId) {
        return brandRepository.getOne(itemId);
    }
}

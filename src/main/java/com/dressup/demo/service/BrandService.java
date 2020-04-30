package com.dressup.demo.service;

import com.dressup.demo.dto.BrandDto;
import com.dressup.demo.dto.ItemDto;
import com.dressup.demo.models.Brand;
import com.dressup.demo.models.Item;
import com.dressup.demo.models.User;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrands();

    Brand getBrand(Long id);

    Brand addBrand(BrandDto brandData);

    Brand addBrand(BrandDto brandData, Long id);

    void deleteBrand(Long id);

    void updateBrand(BrandDto brandData, Long id);

}
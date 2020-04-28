package com.dressup.demo.dto;

import com.dressup.demo.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BrandDto {
    private int id;
    private String name;
    private String description;
    private String logoUrl;

    public static BrandDto from(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .logoUrl(brand.getLogoUrl())
                .build();
    }


    public static List<BrandDto> from(List<Brand> brands) {
        return brands.stream()
                .map(BrandDto::from)
                .collect(Collectors.toList());
    }
}

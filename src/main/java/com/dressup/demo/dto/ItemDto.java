package com.dressup.demo.dto;


import com.dressup.demo.models.Item;
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
public class ItemDto {
    private int id;
    private String name;
    private String description;
    private BrandDto brand;
   // private LookDto look;
    private UserDto owner;
    private String image_url;

    public static ItemDto from(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .image_url(item.getImage_url())
                .brand(BrandDto.from(item.getBrand()))
                .owner(UserDto.from(item.getOwner()))
                .build();
    }


    public static List<ItemDto> from(List<Item> items) {
        return items.stream()
                .map(ItemDto::from)
                .collect(Collectors.toList());
    }
}
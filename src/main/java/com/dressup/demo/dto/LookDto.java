package com.dressup.demo.dto;

import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LookDto {
    private long id;
    private String name;
    private String description;
    private UserDto owner;
    private List<Item> items;

    public static LookDto from(Look look) {
        return LookDto.builder()
                .id(look.getId())
                .name(look.getName())
                .description(look.getDescription())
                .items(look.getItems())
                .owner(UserDto.from(look.getOwner()))
                .build();
    }


    public static List<LookDto> from(List<Look> looks) {
        return looks.stream()
                .map(LookDto::from)
                .collect(Collectors.toList());
    }
}

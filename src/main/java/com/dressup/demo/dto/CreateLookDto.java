package com.dressup.demo.dto;


import com.dressup.demo.models.Item;
import com.dressup.demo.models.Look;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateLookDto {
    private Long id;
    @Length(min = 1, max = 140)
    private String description;
    private List<Item> items;
    private UserDto owner;

    public static CreateLookDto from(Look look) {
        return CreateLookDto.builder()
                .id(look.getId())
                .description(look.getDescription())
                .items(look.getItems())
                .owner(UserDto.from(look.getOwner()))
                .build();
    }

    public static List<CreateLookDto> from(List<Look> tweets) {
        return tweets.stream()
                .map(CreateLookDto::from)
                .collect(Collectors.toList());
    }
}
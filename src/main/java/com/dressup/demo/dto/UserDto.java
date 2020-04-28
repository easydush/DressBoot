package com.dressup.demo.dto;

import com.dressup.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;


    public static UserDto from(User user) {
        return UserDto.builder()
                .fullName(user.getFullName())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .id(user.getId())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }

}

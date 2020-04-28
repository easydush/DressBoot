package com.dressup.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    @Length(min = 4)
    private String username;

    @Length(min = 2)
    private String name;

    @Length(min = 5)
    private String fullName;

    @Length(min = 8)
    private String password;

}
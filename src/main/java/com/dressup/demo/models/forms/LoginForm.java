package com.dressup.demo.models.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginForm {
    private String username;
    private String password;
}

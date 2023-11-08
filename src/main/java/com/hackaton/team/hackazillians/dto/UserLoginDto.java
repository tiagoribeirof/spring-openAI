package com.hackaton.team.hackazillians.dto;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class UserLoginDto {

    private String name;
    private String email;
    private String password;
    private String username;
}

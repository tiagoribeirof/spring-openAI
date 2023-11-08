package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.dto.LoginDto;
import com.hackaton.team.hackazillians.dto.UserDto;

public interface LoginService {

    UserDto login(LoginDto loginDto);
}

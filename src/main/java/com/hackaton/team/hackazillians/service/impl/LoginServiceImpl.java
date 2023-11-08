package com.hackaton.team.hackazillians.service.impl;

import com.hackaton.team.hackazillians.entities.User;
import com.hackaton.team.hackazillians.repositories.UserRepository;
import com.hackaton.team.hackazillians.dto.LoginDto;
import com.hackaton.team.hackazillians.dto.UserDto;
import com.hackaton.team.hackazillians.mapper.UserMapper;
import com.hackaton.team.hackazillians.service.LoginService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;
    @Override
    public UserDto login(LoginDto loginDto) {
        User user = userRepository.findByUserNameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }
        return userMapper.toDto(user);
    }

}

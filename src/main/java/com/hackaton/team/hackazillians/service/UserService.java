package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.entities.User;
import com.hackaton.team.hackazillians.repositories.UserRepository;
import com.hackaton.team.hackazillians.dto.UserLoginDto;
import com.hackaton.team.hackazillians.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    public User createUser(UserLoginDto user) {
        if(!getUser(user.getUsername())){
            User entity = userMapper.toEntity(user);
            return repository.save(entity);
        }
        return null;
    }

    public Boolean getUser(String name) {
        User user = repository.findByUserName(name);
        return user != null;
    }
}

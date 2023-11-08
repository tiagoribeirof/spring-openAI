package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.User;
import com.hackaton.team.hackazillians.dto.UserDto;
import com.hackaton.team.hackazillians.dto.UserLoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    public UserDto toDto(User user);

    @Mapping(target = "userName", source = "userName")
    User toEntity(UserDto userDto);

    @Mapping(target = "userName", source = "username")
    User toEntity(UserLoginDto userDto);
}

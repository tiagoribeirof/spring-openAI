package com.hackaton.team.hackazillians.controller;

import com.hackaton.team.hackazillians.dto.UserLoginDto;
import com.hackaton.team.hackazillians.entities.User;
import com.hackaton.team.hackazillians.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserLoginDto user){
        User serviceUser = service.createUser(user);
        if(serviceUser!=null){
            return ResponseEntity.ok(serviceUser);
        }
        return  ResponseEntity.badRequest().body("User already exists");
    }

    @GetMapping()
    public Boolean getUser(@RequestParam("userId") String name){
        return service.getUser(name);
    }
}

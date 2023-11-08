package com.hackaton.team.hackazillians.controller;

import com.hackaton.team.hackazillians.dto.LoginDto;
import com.hackaton.team.hackazillians.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            return ResponseEntity.ok(service.login(loginDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

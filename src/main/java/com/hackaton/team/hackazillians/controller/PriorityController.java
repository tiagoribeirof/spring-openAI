package com.hackaton.team.hackazillians.controller;

import com.hackaton.team.hackazillians.dto.PriorityDto;
import com.hackaton.team.hackazillians.service.PriorityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/priority")
@RestController
@AllArgsConstructor
public class PriorityController {

    private final PriorityService service;

    @GetMapping
    public List<PriorityDto> getPriority(){
        return service.findAll();
    }
}

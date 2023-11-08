package com.hackaton.team.hackazillians.controller;

import com.hackaton.team.hackazillians.dto.AssessmentDto;
import com.hackaton.team.hackazillians.handler.UserInterceptor;
import com.hackaton.team.hackazillians.service.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment")
@AllArgsConstructor
public class AssessmentController {

    @Autowired
    private final AssessmentService service;

    private final UserInterceptor user;

    @GetMapping
    public AssessmentDto getAssessment(){
        return service.findAssessmentByUserId(user.getUserId());
    }

}

package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.repositories.AssessmentRepository;
import com.hackaton.team.hackazillians.dto.AssessmentDto;
import com.hackaton.team.hackazillians.mapper.AssessmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository repository;

    @Autowired
    private AssessmentMapper mapper;

    public AssessmentDto findAssessmentByUserId(Integer userId){
       return mapper.toDto(repository.findByUser_Id(userId));
    }


}

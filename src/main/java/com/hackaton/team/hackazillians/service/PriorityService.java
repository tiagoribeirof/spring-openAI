package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.repositories.PriorityRepository;
import com.hackaton.team.hackazillians.dto.PriorityDto;
import com.hackaton.team.hackazillians.mapper.PriorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    private PriorityRepository repository;

    @Autowired
    private PriorityMapper mapper;

    public List<PriorityDto> findAll(){
        return mapper.toDtoList(repository.findAll());
    }
}

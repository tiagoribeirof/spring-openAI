package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.Priority;
import com.hackaton.team.hackazillians.dto.PriorityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriorityMapper {

    PriorityDto toDto(Priority priority);

    List<PriorityDto> toDtoList(List<Priority> priority);
}

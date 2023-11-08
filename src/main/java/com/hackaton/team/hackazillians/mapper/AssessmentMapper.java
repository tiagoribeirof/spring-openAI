package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.Assessment;
import com.hackaton.team.hackazillians.dto.AssessmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssessmentMapper {

    @Mapping(target = "nextAssessmentDate", source = "nextAssessmentDate", dateFormat = "dd/MM/yyyy")
    AssessmentDto toDto(Assessment assessment);
}

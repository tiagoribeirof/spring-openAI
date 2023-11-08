package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.StudyRecomendation;
import com.hackaton.team.hackazillians.dto.StudyRecomendationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyRecomendationMapper {

    @Mapping(target = "achieveId", source = "achieveId")
    @Mapping(target = "typeId.id", source = "typeId.id")
    @Mapping(target = "typeId.type", source = "typeId.type")
    StudyRecomendation toEntity(StudyRecomendationDto studyRecomendationDto);


    List<StudyRecomendationDto> toDto(List<StudyRecomendation> studyRecomendations);


}

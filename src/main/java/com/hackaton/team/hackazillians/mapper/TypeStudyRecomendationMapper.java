package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.TypeStudyRecomendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeStudyRecomendationMapper {

    TypeStudyRecomendation toEntity(TypeStudyRecomendation typeStudyRecomendation);
}

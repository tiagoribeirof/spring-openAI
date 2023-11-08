package com.hackaton.team.hackazillians.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudyRecomendationCreatedDto {

    private Integer id;
    private TypeStudyRecomendationDto typeId;
    private String description;
}

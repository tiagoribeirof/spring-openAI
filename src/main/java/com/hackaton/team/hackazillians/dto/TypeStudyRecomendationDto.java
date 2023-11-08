package com.hackaton.team.hackazillians.dto;

import com.hackaton.team.hackazillians.entities.TypeStudyRecomendation;
import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link TypeStudyRecomendation}
 */
@Builder
@Data
public class TypeStudyRecomendationDto  {

    private Integer id;
    private String type;
}
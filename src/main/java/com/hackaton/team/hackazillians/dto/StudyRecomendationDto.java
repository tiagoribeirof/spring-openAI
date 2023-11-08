package com.hackaton.team.hackazillians.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.team.hackazillians.entities.StudyRecomendation;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link StudyRecomendation}
 */
@Builder
@Data
public class StudyRecomendationDto implements Serializable {

    private Integer id;
    private TypeStudyRecomendationDto typeId;
    private String description;
    @JsonIgnore
    private AchieveGoalDto achieveId;

}
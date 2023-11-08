package com.hackaton.team.hackazillians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackaton.team.hackazillians.entities.AchieveGoal;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link AchieveGoal}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AchieveGoalDto implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("progress")
    private int progress;
    @JsonProperty("studyRecomendation")
    private List<StudyRecomendationDto> studyRecomendation;

}
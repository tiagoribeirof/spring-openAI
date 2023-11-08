package com.hackaton.team.hackazillians.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AchieveGoalCreatedDto  implements Serializable {


    private int id;

    private String name;

    private String description;

    private int progress;

    private List<StudyRecomendationCreatedDto> studyRecomendation;
}

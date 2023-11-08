package com.hackaton.team.hackazillians.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoalDto implements Serializable {

    private int id;

    private int userId;

    private LocalDate startDate;

    private LocalDate expiredDate;

    private String name;

    private String description;

    private int progress;

    private Boolean linkedReview;

    private String priority;

    private List<AchieveGoalDto> achieveGoal;
}

package com.hackaton.team.hackazillians.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoalAchieveDto {

    private int sizeData;
    private List<FindGoalsAiDto> goals;
}

package com.hackaton.team.hackazillians.dto.chat;

import com.hackaton.team.hackazillians.dto.GoalDto;
import lombok.Data;

import java.util.List;

@Data
public class GoalAchieveResponseDto {

    private List<GoalDto> goals;
}

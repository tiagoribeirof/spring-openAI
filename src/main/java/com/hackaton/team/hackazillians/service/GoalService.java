package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.dto.GoalCretedDTO;
import com.hackaton.team.hackazillians.dto.GoalDto;

import java.util.List;

public interface GoalService {

    List<GoalCretedDTO> getGoalById(Integer id);

    List<GoalDto> createOrUpdateGoal(List<GoalDto> goalDto);

    Object updateGoal(GoalDto goalDto);
}

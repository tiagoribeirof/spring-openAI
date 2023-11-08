package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.entities.AchieveGoal;
import com.hackaton.team.hackazillians.dto.AchieveGoalDto;
import com.hackaton.team.hackazillians.dto.GoalAchieveDto;
import com.hackaton.team.hackazillians.dto.chat.GoalAchieveResponseDto;

public interface AchieveGoalService {

    GoalAchieveResponseDto findAchievesByGoals(GoalAchieveDto goalAchieveDto, Integer userId);

     AchieveGoal updateAchieveGoal(AchieveGoalDto achieveGoal);
     AchieveGoal updateAchieveGoalProgress(Integer id, Integer progress);



}

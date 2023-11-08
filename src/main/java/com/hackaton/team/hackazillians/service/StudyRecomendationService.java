package com.hackaton.team.hackazillians.service;

import com.hackaton.team.hackazillians.constant.TypeRecomendation;
import com.hackaton.team.hackazillians.dto.AchieveGoalDto;
import com.hackaton.team.hackazillians.dto.GoalDto;
import com.hackaton.team.hackazillians.dto.StudyRecomendationDto;

import java.util.List;

public interface StudyRecomendationService {


    List<StudyRecomendationDto> findRecomendationByAchieve(AchieveGoalDto achieveGoalDto,
                                                           TypeRecomendation typeStudyRecomendation);


    List<GoalDto> saveStudyRecommendation(List<GoalDto> achieveGoalDto);
}

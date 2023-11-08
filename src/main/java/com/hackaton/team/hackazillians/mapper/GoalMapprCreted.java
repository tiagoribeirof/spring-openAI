package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.AchieveGoal;
import com.hackaton.team.hackazillians.entities.Goal;
import com.hackaton.team.hackazillians.entities.StudyRecomendation;
import com.hackaton.team.hackazillians.dto.AchieveGoalCreatedDto;
import com.hackaton.team.hackazillians.dto.GoalCretedDTO;
import com.hackaton.team.hackazillians.dto.StudyRecomendationCreatedDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface GoalMapprCreted {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "priority", source = "priority.nivel")
    @Mapping(target = "linkedReview", source = "linkedReview")
    GoalCretedDTO toDto(Goal goal);

    List<GoalCretedDTO> toDto(List<Goal> goals);

    AchieveGoalCreatedDto toAchieveGoalDto(AchieveGoal achieveGoal);

    List<AchieveGoalCreatedDto> toAchieveGoalDto(List<AchieveGoalCreatedDto> achieveGoal);

    List<StudyRecomendationCreatedDto> toStudyRecomendationDto(List<StudyRecomendation> studyRecomendation);

    StudyRecomendationCreatedDto toStudyRecomendationDto(StudyRecomendation studyRecomendation);
}

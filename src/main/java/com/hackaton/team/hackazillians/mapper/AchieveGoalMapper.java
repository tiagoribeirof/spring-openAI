package com.hackaton.team.hackazillians.mapper;

import com.hackaton.team.hackazillians.entities.AchieveGoal;
import com.hackaton.team.hackazillians.dto.AchieveGoalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AchieveGoalMapper {

    AchieveGoal toEntity(AchieveGoalDto achieveGoal);

    @Mapping(target = "goalId.id", source = "goal.id")
    @Mapping(target = "goalId.user.id", source = "goalId.userId")
    List<AchieveGoal> toEntity(List<AchieveGoalDto> achieveGoalDtos);

    AchieveGoalDto toDto(AchieveGoal achieveGoal);

    List<AchieveGoalDto> toDtoList(List<AchieveGoal> achieveGoals);





}

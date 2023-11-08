package com.hackaton.team.hackazillians.service.impl;

import com.hackaton.team.hackazillians.entities.AchieveGoal;
import com.hackaton.team.hackazillians.repositories.AchieveGoalRepository;
import com.hackaton.team.hackazillians.dto.AchieveGoalDto;
import com.hackaton.team.hackazillians.dto.FindGoalsAiDto;
import com.hackaton.team.hackazillians.dto.GoalAchieveDto;
import com.hackaton.team.hackazillians.dto.GoalDto;
import com.hackaton.team.hackazillians.dto.chat.GoalAchieveResponseDto;

import com.hackaton.team.hackazillians.handler.UserInterceptor;
import com.hackaton.team.hackazillians.mapper.AchieveGoalMapper;
import com.hackaton.team.hackazillians.service.AchieveGoalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AchieveGoalServiceImpl implements AchieveGoalService {

    private final ChatAIAchievesService aiAchieveService;
    private final UserInterceptor user;
    private final AchieveGoalRepository achieveGoalRepository;
    private final AchieveGoalMapper achieveGoalMapper;
    @Override
//    @Cacheable(value = "achieve", key = "#goalAchieveDto")
    public GoalAchieveResponseDto findAchievesByGoals(GoalAchieveDto goalAchieveDto, Integer userId) {
        List<GoalDto> goals = new ArrayList<>();
        for (FindGoalsAiDto goal : goalAchieveDto.getGoals()) {
            GoalDto goalDto = new GoalDto();
            goalDto.setName(goal.getName());
            goalDto.setProgress(0);
            goalDto.setStartDate(LocalDate.now());
            goalDto.setExpiredDate(LocalDate.now().plusMonths(6));
            goalDto.setDescription(goal.getDescription());
            goalDto.setUserId(user.getUserId());
            String finalOfQuestion =  goal.getDescription() != null && !goal.getDescription().isEmpty() ? " AND " + goal.getDescription() : "";
            String question = goal.getName() + finalOfQuestion;
            List<String> listGoalsAi = aiAchieveService.askGoalToAI(question);
            List<AchieveGoalDto> achieveGoal = new ArrayList<>();
            for (String response : listGoalsAi) {
                AchieveGoalDto achieveGoalDto = new AchieveGoalDto();
                achieveGoalDto.setName(goal.getName());
                achieveGoalDto.setDescription(response);
                achieveGoalDto.setProgress(0);
                achieveGoal.add(achieveGoalDto);
            }

            goalDto.setAchieveGoal(achieveGoal.subList(0, goalAchieveDto.getSizeData()));
            goals.add(goalDto);

        }
        GoalAchieveResponseDto goalAchieveResponseDto = new GoalAchieveResponseDto();
        goalAchieveResponseDto.setGoals(goals);
        return goalAchieveResponseDto;
    }


    public AchieveGoal updateAchieveGoal(AchieveGoalDto achieveGoal) {
        AchieveGoal entity = achieveGoalMapper.toEntity(achieveGoal);
        return achieveGoalRepository.save(entity);

    }

    public AchieveGoal updateAchieveGoalProgress(Integer id, Integer progress) {
        AchieveGoal achieveGoal = achieveGoalRepository.findById(id).orElseThrow(RuntimeException::new);
        achieveGoal.setProgress(progress);
        return achieveGoalRepository.save(achieveGoal);
    }
}

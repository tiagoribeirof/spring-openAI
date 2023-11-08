package com.hackaton.team.hackazillians.service.impl;



import com.hackaton.team.hackazillians.entities.AchieveGoal;
import com.hackaton.team.hackazillians.entities.Goal;
import com.hackaton.team.hackazillians.repositories.AchieveGoalRepository;
import com.hackaton.team.hackazillians.repositories.GoalRepository;
import com.hackaton.team.hackazillians.repositories.PriorityRepository;
import com.hackaton.team.hackazillians.dto.GoalCretedDTO;
import com.hackaton.team.hackazillians.dto.GoalDto;

import com.hackaton.team.hackazillians.handler.UserInterceptor;
import com.hackaton.team.hackazillians.mapper.AchieveGoalMapper;
import com.hackaton.team.hackazillians.mapper.GoalMapper;
import com.hackaton.team.hackazillians.mapper.GoalMapprCreted;

import com.hackaton.team.hackazillians.service.GoalService;
import com.hackaton.team.hackazillians.service.StudyRecomendationService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    private final GoalMapper goalMapper;

    private final AchieveGoalMapper achieveGoalMapper;

    private final AchieveGoalRepository achieveGoalRepository;

    private final UserInterceptor user;

    private final StudyRecomendationService studyRecomendationService;

    private final GoalMapprCreted goalMapprCreted;

    private final PriorityRepository priorityRepository;


    @Transactional
    public List<GoalDto> createOrUpdateGoal(List<GoalDto> goalDto) {
        List<Goal> goals = new ArrayList<>();
        for (GoalDto goal : goalDto) {
            goal.setUserId(user.getUserId());
            Goal goalEntity = goalMapper.toEntity(goal);
            if(!(goal.getPriority() == null)){
                goalEntity.setPriority(priorityRepository.findByNivel(goal.getPriority()));
            }else {
                goalEntity.setPriority(priorityRepository.findByNivel("Low"));
            }
            goalRepository.save(goalEntity);
            goals.add(goalEntity);
            goal = goalMapper.toDto(goalEntity);
            List<AchieveGoal> achieveGoalList = achieveGoalMapper.toEntity(goal.getAchieveGoal());
            achieveGoalList.forEach(achieveGoal -> achieveGoal.setGoalId(goalEntity));
            List<AchieveGoal> achieveGoalSaved = achieveGoalList.stream().map(achieveGoalRepository::save).collect(Collectors.toList());
            goalEntity.setAchieveGoal(achieveGoalSaved);
        }
        return studyRecomendationService.saveStudyRecommendation(goalMapper.toDto(goals));
    }

    @Override
    public Goal updateGoal(GoalDto goalDto) {
        return goalRepository.save(goalMapper.toEntity(goalDto));
    }

    @Override
    public List<GoalCretedDTO> getGoalById(Integer id) {
        List<Goal> goals = goalRepository.findByUserId(id);

        goals.forEach(goal -> {
            int media = (int) goal.getAchieveGoal().stream()
                    .mapToInt(AchieveGoal::getProgress)
                    .average()
                    .orElse(0.0);

            goal.setProgress(media);
        });
        return goalMapprCreted.toDto(goals);
    }


}

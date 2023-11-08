package com.hackaton.team.hackazillians.service.impl;

import com.hackaton.team.hackazillians.constant.TypeQuestion;
import com.hackaton.team.hackazillians.entities.StudyRecomendation;
import com.hackaton.team.hackazillians.repositories.AchieveGoalRepository;
import com.hackaton.team.hackazillians.repositories.StudyRecomendationRepository;
import com.hackaton.team.hackazillians.constant.TypeRecomendation;
import com.hackaton.team.hackazillians.dto.AchieveGoalDto;
import com.hackaton.team.hackazillians.dto.GoalDto;
import com.hackaton.team.hackazillians.dto.StudyRecomendationDto;
import com.hackaton.team.hackazillians.dto.TypeStudyRecomendationDto;
import com.hackaton.team.hackazillians.mapper.StudyRecomendationMapper;
import com.hackaton.team.hackazillians.service.StudyRecomendationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudyRecomendationServiceImpl implements StudyRecomendationService {


    private final ChatAiStudyRecomendationService chatAiStudyRecomendationService;
    private final StudyRecomendationRepository studyRecomendationRepository;
    private final StudyRecomendationMapper studyRecomendationMapper;
    private final AchieveGoalRepository achieveGoalRepository;

    private static final int MAX_RESPONSE = 3;

    @Override
    public List<StudyRecomendationDto> findRecomendationByAchieve(AchieveGoalDto achieveGoalDto,
                                                                  TypeRecomendation typeStudyRecomendation) {
        TypeQuestion typeQuestion = TypeQuestion.STUDY_RECOMMENDATION_READING;
        if(TypeRecomendation.COURSE.equals(typeStudyRecomendation)){
            typeQuestion = TypeQuestion.STUDY_RECOMMENDATION_COURSES;
        }
        List<String> recomendations = chatAiStudyRecomendationService.askStudyRecomendationToAI(achieveGoalDto.getDescription(),
                typeQuestion);
        return recomendations.stream().map(recomendation -> StudyRecomendationDto.builder()
                .id(null)
                .description(recomendation)
                .achieveId(achieveGoalDto)
                .typeId(TypeStudyRecomendationDto.builder()
                        .id(typeStudyRecomendation.getId())
                        .type(typeStudyRecomendation.name()).build())
                .build()).limit(MAX_RESPONSE).collect(Collectors.toList());

    }

    @Override
    public List<GoalDto> saveStudyRecommendation(List<GoalDto> goals) {

           goals.forEach(goalDto -> {
                   AtomicInteger index = new AtomicInteger(0);
                   List<AchieveGoalDto> achieveGoalDtoList = new ArrayList<>();
                   goalDto.getAchieveGoal().forEach(achieveGoalDto -> {
                       if (index.get() > 0) {
                           List<StudyRecomendationDto> studyRecomendationDtos = findRecomendationByAchieve(achieveGoalDto, TypeRecomendation.READING);
                           List<StudyRecomendationDto> studyRecomendationDtosCourse = findRecomendationByAchieve(achieveGoalDto, TypeRecomendation.COURSE);
                           studyRecomendationDtos.addAll(studyRecomendationDtosCourse);
                              List<StudyRecomendation> listS = studyRecomendationDtos.stream().map(studyRecomendationDto -> {
                              StudyRecomendation sr = studyRecomendationMapper.toEntity(studyRecomendationDto);

                              sr.setAchieveId(achieveGoalRepository.findById(achieveGoalDto.getId()).get());
                              return sr;
                           }).map(studyRecomendationRepository::save).collect(Collectors.toList());
                           achieveGoalDto.setStudyRecomendation(studyRecomendationMapper.toDto(listS));
                       }
                       achieveGoalDtoList.add(achieveGoalDto);
                       index.getAndIncrement();
                   });
                   goalDto.setAchieveGoal(achieveGoalDtoList);
           });

              return goals;

    }


}

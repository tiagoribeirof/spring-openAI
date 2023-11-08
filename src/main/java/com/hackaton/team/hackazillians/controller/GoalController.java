package com.hackaton.team.hackazillians.controller;

import com.hackaton.team.hackazillians.dto.GoalAchieveDto;
import com.hackaton.team.hackazillians.dto.GoalCretedDTO;
import com.hackaton.team.hackazillians.dto.GoalDto;
import com.hackaton.team.hackazillians.dto.chat.CreateGoalDto;
import com.hackaton.team.hackazillians.handler.UserInterceptor;
import com.hackaton.team.hackazillians.service.AchieveGoalService;
import com.hackaton.team.hackazillians.service.GoalService;
import lombok.AllArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/goals")
@AllArgsConstructor
public class GoalController {

    private final GoalService goalService;
    private final AchieveGoalService achieveService;
    private final UserInterceptor user;


    @GetMapping
    public List<GoalCretedDTO> getGoals(){
        return this.goalService.getGoalById(user.getUserId());
    }

    @PostMapping("/achieve")
    public ResponseEntity<?> findAchievesByGoals(@RequestBody GoalAchieveDto goalAchieveDto) {
         return ResponseEntity.ok(achieveService.findAchievesByGoals(goalAchieveDto, user.getUserId()));
    }

    @PostMapping
    public ResponseEntity<?> createGoal(@RequestBody CreateGoalDto goalDto){
        return ResponseEntity.ok(goalService.createOrUpdateGoal(goalDto.getGoals()));

    }

    @PutMapping
    public ResponseEntity<?> updateGoal(@RequestBody GoalDto goalDto){
        return ResponseEntity.ok(goalService.updateGoal(goalDto));
    }

}

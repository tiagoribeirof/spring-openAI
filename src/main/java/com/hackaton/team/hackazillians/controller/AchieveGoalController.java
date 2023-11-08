package com.hackaton.team.hackazillians.controller;

import com.hackaton.team.hackazillians.dto.AchieveGoalDto;
import com.hackaton.team.hackazillians.entities.AchieveGoal;
import com.hackaton.team.hackazillians.service.AchieveGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/achieve-goals")
public class AchieveGoalController {

    @Autowired
    private AchieveGoalService achieveGoalService;

    @PutMapping
    public AchieveGoal updateAchieveGoal(@RequestBody AchieveGoalDto achieveGoal){
        return achieveGoalService.updateAchieveGoal(achieveGoal);
    }

    @PutMapping("/progress")
    public AchieveGoal updateAchieveGoalProgress(@RequestParam("id") Integer id, @RequestParam("progress") Integer progress){
        return achieveGoalService.updateAchieveGoalProgress(id, progress);
    }

}

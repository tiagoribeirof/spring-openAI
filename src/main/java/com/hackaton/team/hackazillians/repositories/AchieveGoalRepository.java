package com.hackaton.team.hackazillians.repositories;

import com.hackaton.team.hackazillians.entities.AchieveGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchieveGoalRepository extends JpaRepository<AchieveGoal, Integer>{
}

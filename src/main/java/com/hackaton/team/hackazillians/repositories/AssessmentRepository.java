package com.hackaton.team.hackazillians.repositories;

import com.hackaton.team.hackazillians.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

    Assessment findByUser_Id(Integer userId);
}

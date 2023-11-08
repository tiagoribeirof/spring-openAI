package com.hackaton.team.hackazillians.repositories;

import com.hackaton.team.hackazillians.entities.StudyRecomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRecomendationRepository extends JpaRepository<StudyRecomendation, Integer> {
}

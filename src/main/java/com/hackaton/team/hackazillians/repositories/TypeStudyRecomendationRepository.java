package com.hackaton.team.hackazillians.repositories;

import com.hackaton.team.hackazillians.entities.TypeStudyRecomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeStudyRecomendationRepository extends JpaRepository<TypeStudyRecomendation, Integer> {
}

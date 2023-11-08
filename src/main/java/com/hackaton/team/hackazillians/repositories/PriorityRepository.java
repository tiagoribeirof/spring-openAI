package com.hackaton.team.hackazillians.repositories;

import com.hackaton.team.hackazillians.entities.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    Priority findByNivel(String nivel);
}

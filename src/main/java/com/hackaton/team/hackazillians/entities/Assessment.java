package com.hackaton.team.hackazillians.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment")
public class Assessment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "last_avaliation")
    @JsonBackReference
    private LasteAvaliation lastAvaliation;

    @Column(name = "dt_next_Assessment")
    private LocalDate nextAssessmentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

//    @OneToMany(mappedBy = "linkedReview", fetch = FetchType.LAZY)
//    private List<Goal> goal;
}

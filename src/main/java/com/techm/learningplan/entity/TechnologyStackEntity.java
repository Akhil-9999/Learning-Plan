package com.techm.learningplan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "technology_stack")
@Getter
@Setter
public class TechnologyStackEntity {
    @Id
    @Column(name = "technology_stack_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer technologyStackId;
    @Column(name = "technology")
    private String technology;
    @Column(name = "level")
    private String level;

    @OneToOne
    @JoinColumn(name = "technology_stack_id")
    private LearningStatusEntity learningStatus;
}

package com.techm.learningplan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "learning_status")
@Getter
@Setter
public class LearningStatusEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer learningStatusId;
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "percentage")
    private String percentage;
    @Column(name = "last_week_percentage")
    private String lastWeekPercentage;
    @Column(name = "date")
    private String date;

    @OneToOne(orphanRemoval = true, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "technology_stack_id")
    private TechnologyStackEntity technologyStackEntity;
}

package com.techm.learningplan.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TechnologyStack {
    private Integer technologyStackId;
    private String technology;
    private String level;
    private LearningStatus learningStatus;
}

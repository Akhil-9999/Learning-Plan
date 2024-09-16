package com.techm.learningplan.model;


import com.techm.learningplan.entity.TechnologyStackEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LearningStatus {
    private String empId;
    private String percentage;
    private String date;
    private Integer technologyStackId;
    private List<TechnologyStackEntity> technologyStackEntityList;
    private List<LearningStatus> learningStatusList;
    private TechnologyStackEntity technologyStackEntity;
    private String technology;
}
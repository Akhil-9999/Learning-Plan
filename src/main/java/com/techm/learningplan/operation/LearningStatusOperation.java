package com.techm.learningplan.operation;

import com.techm.learningplan.entity.LearningStatusEntity;
import com.techm.learningplan.entity.TechnologyStackEntity;
import com.techm.learningplan.model.LearningStatus;
import com.techm.learningplan.repository.LearningStatusRepository;
import com.techm.learningplan.repository.TechnologyStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningStatusOperation {

    @Autowired
    private LearningStatusRepository learningStatusRepository;

    @Autowired
    private TechnologyStackRepository technologyStackRepository;


    public void saveData(LearningStatus learningStatus) {
        LearningStatusEntity learningStatusEntity = copyDataFromTraineeStatus(learningStatus);
        LearningStatusEntity prevLearningStatusEntity = getLearningStatusByIdAndTechnologyStackId(learningStatusEntity);
        if (null != prevLearningStatusEntity) {
            learningStatusEntity.setLearningStatusId(prevLearningStatusEntity.getLearningStatusId());
            learningStatusEntity.getTechnologyStackEntity().setLevel(prevLearningStatusEntity.getTechnologyStackEntity().getLevel());
            learningStatusEntity.getTechnologyStackEntity().setTechnology(prevLearningStatusEntity.getTechnologyStackEntity().getTechnology());
            learningStatusEntity.getTechnologyStackEntity().setLearningStatus(prevLearningStatusEntity.getTechnologyStackEntity().getLearningStatus());
            learningStatusEntity.setLastWeekPercentage(prevLearningStatusEntity.getPercentage());
        }
        learningStatusRepository.save(learningStatusEntity);
    }

    public void getData(LearningStatus learningStatus) {
        learningStatus.setTechnologyStackEntityList(technologyStackRepository.findAll());


    }

    private LearningStatusEntity getLearningStatusByIdAndTechnologyStackId(LearningStatusEntity learningStatusEntity) {
        return learningStatusRepository.findLearningStatusByEmpIdAndTechnologyStackId(learningStatusEntity.getEmpId(), learningStatusEntity.getTechnologyStackEntity().getTechnologyStackId());

    }


    private LearningStatusEntity copyDataFromTraineeStatus(LearningStatus learningStatus) {
        LearningStatusEntity learningStatusEntity = new LearningStatusEntity();

        learningStatusEntity.setEmpId(learningStatus.getEmpId());
        learningStatusEntity.setPercentage(learningStatus.getPercentage());
        learningStatusEntity.setLastWeekPercentage(learningStatus.getPercentage());
        learningStatusEntity.setDate(learningStatus.getDate());
        TechnologyStackEntity technologyStackEntity = new TechnologyStackEntity();
        technologyStackEntity.setTechnologyStackId(learningStatus.getTechnologyStackId());
        learningStatusEntity.setTechnologyStackEntity(technologyStackEntity);


        return learningStatusEntity;

    }


    public List<LearningStatus> getEmployeeDataByEmployeeId(LearningStatus learningStatus) {
        List<LearningStatusEntity> learningStatusEntityList = learningStatusRepository.findByEmpId(learningStatus.getEmpId());
        return copyLearningStatusEntityListToLearningStatusList(learningStatusEntityList);

    }

    private List<LearningStatus> copyLearningStatusEntityListToLearningStatusList(List<LearningStatusEntity> learningStatusEntityList) {
        return learningStatusEntityList.stream().map(this::copyLearningStatusEntityToLearningStatus).collect(Collectors.toList());
    }

    private LearningStatus copyLearningStatusEntityToLearningStatus(LearningStatusEntity learningStatusEntity) {
        LearningStatus learningStatus = new LearningStatus();
        learningStatus.setEmpId(learningStatusEntity.getEmpId());
        learningStatus.setTechnology(learningStatusEntity.getTechnologyStackEntity().getTechnology());
        learningStatus.setPercentage(learningStatusEntity.getLastWeekPercentage());
        learningStatus.setTechnologyStackEntity(learningStatusEntity.getTechnologyStackEntity());
        return learningStatus;
    }


}


package com.techm.learningplan.repository;

import com.techm.learningplan.entity.LearningStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningStatusRepository extends JpaRepository<LearningStatusEntity, Integer> {
    List<LearningStatusEntity> findByEmpId(String empId);

    @Query("SELECT ls FROM LearningStatusEntity ls WHERE ls.empId = :empId and ls.technologyStackEntity.technologyStackId = :technologyStackId")
    LearningStatusEntity findLearningStatusByEmpIdAndTechnologyStackId(@Param("empId") String empId, @Param("technologyStackId") Integer technologyStackId);
}

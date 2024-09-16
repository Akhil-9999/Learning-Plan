package com.techm.learningplan.repository;

import com.techm.learningplan.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer> {


    RegistrationEntity findByUserName(String userName);
}

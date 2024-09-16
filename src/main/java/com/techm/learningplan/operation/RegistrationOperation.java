package com.techm.learningplan.operation;

import com.techm.learningplan.entity.RegistrationEntity;
import com.techm.learningplan.entity.SecurityQuestionEntity;
import com.techm.learningplan.model.Login;
import com.techm.learningplan.model.Registration;
import com.techm.learningplan.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class RegistrationOperation {

    @Autowired
    RegistrationRepository registrationRepository;

    public void saveRegistration(Registration registration) {
        RegistrationEntity registrationEntity = copyRegistrationtoRegistrationEntity(registration);
        registrationRepository.save(registrationEntity);
    }

    public Registration loginPage(Login login) {

        RegistrationEntity registrationEntity = registrationRepository.findByUserName(login.getUserName());

        if (registrationEntity != null) {
            Registration registration = new Registration();
            registration.setEmpId(registrationEntity.getEmpId());
            registration.setUserName(registrationEntity.getUserName());
            registration.setPassword(registrationEntity.getPassword());
            return registration;

        }
        return null;
    }

    private RegistrationEntity copyRegistrationtoRegistrationEntity(Registration registration) {
        RegistrationEntity registrationEntity = new RegistrationEntity();

        registrationEntity.setEmpId(registration.getEmpId());
        registrationEntity.setUserName(registration.getUserName());
        registrationEntity.setPassword(registration.getPassword());

        Collection<SecurityQuestionEntity> securityQuestionEntitylist = new ArrayList<>();
        SecurityQuestionEntity securityQuestionEntity = new SecurityQuestionEntity();

        securityQuestionEntity.setQuestion(registration.getSecurityQuestion());
        securityQuestionEntity.setAnswer(registration.getAnswer());
        securityQuestionEntitylist.add(securityQuestionEntity);


        registrationEntity.getSecurityQuestionEntity().addAll(securityQuestionEntitylist);


        return registrationEntity;
    }
}
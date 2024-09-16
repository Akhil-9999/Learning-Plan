package com.techm.learningplan.controller;

import com.techm.learningplan.model.LearningStatus;
import com.techm.learningplan.model.Login;
import com.techm.learningplan.model.Registration;
import com.techm.learningplan.operation.LearningStatusOperation;
import com.techm.learningplan.operation.RegistrationOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/learningplan/api/v1")
@Controller
public class LearningStatusController {

    @Autowired
    private LearningStatusOperation learningStatusOperation;

    @Autowired
    private RegistrationOperation registrationOperation;

    private String empId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @PostMapping("/saveData")
    public String saveData(LearningStatus learningStatus) {
        System.out.println(this.empId);
        learningStatusOperation.saveData(learningStatus);
        learningStatus.setLearningStatusList(learningStatusOperation.getEmployeeDataByEmployeeId(learningStatus));
        learningStatusOperation.getData(learningStatus);
        return "learningstatus";

    }

    @GetMapping("/statusUpdate")
    public String getTechnologyStack(LearningStatus learningStatus) {
        learningStatus.setEmpId(this.empId);
        learningStatusOperation.getData(learningStatus);
        learningStatus.setLearningStatusList(learningStatusOperation.getEmployeeDataByEmployeeId(learningStatus));
        return "learningstatus";
    }

    @PostMapping("/traineeHome")
    public String traineeHomepage(Login login) {
        Registration registration = registrationOperation.loginPage(login);
        this.empId = registration.getEmpId();
        if (registration == null) {
            return "usernull";
        }

        if (!login.getPassword().equals(registration.getPassword())) {
            return "passwordmismatch";
        }

        return "traineehome";


    }

    // @PostMapping("/forgotpasswordData")
/*public String forgotPassword(ForgotPassword forgotPassword){
        Registration registration=registrationOperation.getPassword(forgotPassword);
        if(forgotPassword.getPassword().equals(registration.getPassword())){
            forgotPassword.setPassword(registration.getPassword());
            forgotPassword.setUserName(registration.getUserName());
        }
}*/
    @GetMapping("/login")
    public String showLogin(Login login) {
        return "login";
    }
    @GetMapping("/logout")
    public String showLogOut(Login login) {
        return "logout";
    }

}


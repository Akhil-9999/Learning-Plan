package com.techm.learningplan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.techm.learningplan.controller.LearningStatusController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techm.learningplan.controller.RegistrationController;
import com.techm.learningplan.model.Login;
import com.techm.learningplan.model.Registration;
import com.techm.learningplan.operation.RegistrationOperation;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {
    @Mock
    private RegistrationOperation registrationOperation;

    @InjectMocks
    private RegistrationController registrationController;

    @InjectMocks
    private LearningStatusController learningStatusController;

    @Test
    public void saveRegistration_whenValidRegistration_returnResponse() {


        Registration registration = new Registration();
        doNothing().when(registrationOperation).saveRegistration(registration);
        //String actualResponse = registrationController.saveRegistration(registration);
        //assertEquals("success", actualResponse);

    }
    @Test
    public void showHomePage_whenValid_returnResponse() {

        //  String actualResponse = registrationController.showHomePage();
        // assertEquals("home",actualResponse);
    }
    @Test
    public void showSignupForm_whenValidRegistration_returnResponse() {

        Registration registration = new Registration();
        // String actualResponse = registrationController.showSignupForm(registration);
        // assertEquals("registration", actualResponse);
    }

    @Test
    public void showLogin_whenValidLogin_returnResponse() {

        Login login = new Login();
        String actualResponse = learningStatusController.showLogin(login);
        assertEquals("login",actualResponse);
    }
}
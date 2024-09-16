package com.techm.learningplan.controller;
import com.techm.learningplan.config.Notification;
import com.techm.learningplan.config.ResourceLoader;
import com.techm.learningplan.model.Registration;
import com.techm.learningplan.model.RegistrationResponse;
import com.techm.learningplan.operation.RegistrationOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/learningplan/api/v1")
@RestController
public class RegistrationController {
    @Value("${registration.countries.enabled}")
    private List<String> registrationEnabledCountries;
    @Autowired
    RegistrationOperation registrationOperation;
     @Autowired

    ResourceLoader resourceLoader;
    @ModelAttribute("securityQuestions")
    public static List<String> getsecurityQuestionList() {
        List<String> securityQuestionList=new ArrayList<>();

        securityQuestionList.add("Select Security Question");

        securityQuestionList.add("What is your favourite colour?");
        securityQuestionList.add("What is your favourite Hero?");
        securityQuestionList.add("What is your favourite IPL team?");
        securityQuestionList.add("What is your favourite food?");
        securityQuestionList.add("What is your nickname?");

        return securityQuestionList;

    }

  /*  @PostMapping("/registration")
    public String saveRegistration(@Valid Registration registration) {


        registrationOperation.saveRegistration(registration);
        return "successPage";
    }*/

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/signup")
    public String showSignupForm(Registration registration) {
        return "registration";
    }
    @PostMapping(value = "/v/registration",
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<RegistrationResponse> saveRegistration(@Valid @RequestBody Registration registration) {
        // registrationOperation.saveRegistration(registration);

        System.out.println(resourceLoader.loadFile());

        Optional<String> enabledCountry= registrationEnabledCountries.stream().
                filter(c->c.equalsIgnoreCase(registration.getCountry())).findFirst();


        if(!enabledCountry.isPresent()){
            RegistrationResponse registrationResponse=new RegistrationResponse();
            Notification notification = new Notification();
            notification.setErrorCode(HttpStatus.NOT_IMPLEMENTED.toString());
            notification.setErrorMessage("Not supported other than India");
            notification.setTimestamp(ZonedDateTime.now());
            registrationResponse.setNotification(notification);
            return new ResponseEntity<>(registrationResponse,HttpStatus.NOT_IMPLEMENTED);
        }
        RegistrationResponse registrationResponse=new RegistrationResponse();
        registrationResponse.setData(registration);
        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }

}
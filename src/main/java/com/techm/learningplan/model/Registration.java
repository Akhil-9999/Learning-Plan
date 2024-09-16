package com.techm.learningplan.model;


import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    @NotNull
    private String empId;
    @NotNull
    private String userName;
    private String password;
    private String confirmPassword;
    private String securityQuestion;
    private String country;
    private String answer;
}
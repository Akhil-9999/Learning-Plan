package com.techm.learningplan.model;

import com.techm.learningplan.config.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {
    private Registration data;
    private Notification notification;

}

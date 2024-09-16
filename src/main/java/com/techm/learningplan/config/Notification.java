package com.techm.learningplan.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private ZonedDateTime timestamp;
    private String errorMessage;
    private String errorCode;


}
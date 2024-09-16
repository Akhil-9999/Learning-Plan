package com.techm.learningplan.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "registration")
@Getter
@Setter
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registration_id;
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "registration_id")
    private Collection<SecurityQuestionEntity> securityQuestionEntity = new ArrayList<>();
}
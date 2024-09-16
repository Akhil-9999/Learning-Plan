package com.techm.learningplan.entity;

import javax.persistence.*;


@Entity
@Table(name = "security_question")
public class SecurityQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String security_question_id;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "registration_id")
    private RegistrationEntity registrationEntity;


    public String getSecurity_question_id() {
        return security_question_id;
    }

    public void setSecurity_question_id(String security_question_id) {
        this.security_question_id = security_question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public RegistrationEntity getRegistrationEntity() {
        return registrationEntity;
    }

    public void setRegistrationEntity(RegistrationEntity registrationEntity) {
        this.registrationEntity = registrationEntity;
    }


}


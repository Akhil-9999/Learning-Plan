package com.techm.learningplan.schduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*@Configuration
@EnableScheduling */
public class StatusReminder {
    @Autowired
    private JavaMailSender javaMailSender;
    @Scheduled(cron="0 0/10 14 * * FRI",zone = "IST")
    public void sendStatusRemainderEmail(){
        String[] toAddressList = { "akhilaithagani123@gmail.com", "akhilaithagani2299@gmail.com" };
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("About to send an email>>>>>>>>>");
        message.setFrom("noreply.learningstatus@gmail.com");
        message.setTo(toAddressList);
        message.setSubject("Hi");
        message.setText("Update status please!");
        javaMailSender.send(message);
        System.out.println("Mail sent>>>>>>>>>");

    }

}
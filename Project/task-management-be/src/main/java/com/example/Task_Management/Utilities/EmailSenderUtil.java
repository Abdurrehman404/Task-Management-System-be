package com.example.Task_Management.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMail(String to,String Text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);

        msg.setSubject("Password Reset");
        msg.setText("Your temporary password is "+ Text);

        javaMailSender.send(msg);

    }
}

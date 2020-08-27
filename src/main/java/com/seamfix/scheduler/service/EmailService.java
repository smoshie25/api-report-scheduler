package com.seamfix.scheduler.service;

import com.seamfix.scheduler.entity.ScheduleEntity;
import com.seamfix.scheduler.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

@Component
public class EmailService {

    private final JavaMailSender sender;
    private ScheduleRepository scheduleRepository;

    @Autowired
    public EmailService(JavaMailSender sender, ScheduleRepository scheduleRepository) {
        this.sender = sender;
        this.scheduleRepository = scheduleRepository;
    }

    public void notifyActiveSchedule(){
        Iterable<ScheduleEntity> schedules = scheduleRepository.findAll();

        for (ScheduleEntity schedule: schedules
        ) {
            System.out.println(schedule);
        }
    }

    public void send(String emailTo, String subject, String body) {

        MimeMessagePreparator message = newMessage -> {
            newMessage.setRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(emailTo)
            );
            newMessage.setFrom("from.email@gmail.com");
            newMessage.setSubject(subject);
            newMessage.setText(body);
        };

        this.sender.send(message);
    }
}
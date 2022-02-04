package com.coderefer.producerapp.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JMSMsgScheduler {
    @Autowired
    private JmsTemplate template;
    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleMsg() {
        template.send("test first mq!", session -> session.createTextMessage("From Vamsi at " + new Date()));
        System.out.println("Message sent!");
    }
}

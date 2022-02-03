package com.coderefer.producerapp.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ActiveMQMsgSenderRunner implements CommandLineRunner {
    @Autowired
    private JmsTemplate template;
    @Override
    public void run(String... args) throws Exception {
        template.send("test first mq!", session -> session.createTextMessage("From Vamsi at " + new Date()));
    }
}

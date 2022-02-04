package com.coderefer.consumerapp.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSMsgSubscriber {
    @JmsListener(destination = "test pubsub mq")
    public void readMsg(String txt) {
        System.out.println("Received message: " + txt);
    }
}

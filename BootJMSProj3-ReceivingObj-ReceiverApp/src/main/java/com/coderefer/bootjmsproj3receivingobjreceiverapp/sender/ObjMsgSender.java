package com.coderefer.bootjmsproj3receivingobjreceiverapp.sender;

import com.coderefer.bootjmsproj3receivingobjreceiverapp.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class ObjMsgSender {
    @Autowired
    JmsTemplate template;
    @JmsListener(destination = "obj_mq1")
    public void sendObjDataAsMsg(Actor actor) throws JMSException {
        System.out.println(actor.toString());
    }
}

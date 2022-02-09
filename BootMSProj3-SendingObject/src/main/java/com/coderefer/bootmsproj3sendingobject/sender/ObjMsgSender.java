package com.coderefer.bootmsproj3sendingobject.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.coderefer.bootmsproj3sendingobject.model.Actor;

@Component
public class ObjMsgSender {
    @Autowired
    JmsTemplate template;
    @Scheduled(cron = "*/10 * * * * *")
    public void sendObjDataAsMsg() {
        Actor act = new Actor("Krishna", 21, "Hero");
        template.convertAndSend("obj_mq1",act);
        System.out.println("Object sent as message");
    }
}

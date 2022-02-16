package com.coderefer.bootkafkaproj02restwithkafka.controller;

import com.coderefer.bootkafkaproj02restwithkafka.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMsgController {
    @Autowired
    private MsgProducer p;


//    public String sendMsg(@RequestParam("msg") String msg) {
//
//    }
}

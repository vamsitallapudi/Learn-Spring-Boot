package com.coderefer.bootmsproj3sendingobject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class BootMsProj3SendingObjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMsProj3SendingObjectApplication.class, args);
    }

}

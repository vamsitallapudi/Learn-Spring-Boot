package com.coderefer;

import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataProjApp2 {

    @Autowired
    ICoronaVaccineMgmtService service;

    public static void main(String[] args) {
        //get Access to IOC container
        SpringApplication.run(SpringDataProjApp2.class, args);

    }

}

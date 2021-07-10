package com.coderefer;

import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataProjApp03_JPARepo {

    final ICoronaVaccineMgmtService service;

    @Autowired
    public SpringDataProjApp03_JPARepo(ICoronaVaccineMgmtService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        //get Access to IOC container
        SpringApplication.run(SpringDataProjApp03_JPARepo.class, args);

    }

}

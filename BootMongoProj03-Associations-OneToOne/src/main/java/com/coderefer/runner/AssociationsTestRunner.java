package com.coderefer.runner;

import com.coderefer.document.DrivingLicense;
import com.coderefer.document.Person;
import com.coderefer.service.IRtoMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class AssociationsTestRunner implements CommandLineRunner {
    @Autowired
    private IRtoMgmtService service;
    @Override
    public void run(String... args) throws Exception {
//        prepare objects
//        prepare parent object
        Person per = new Person();
        per.setPid(new Random().nextInt(10000));
        per.setPname("Vamsi");
        per.setPadd("Miyapur");
//        prepare child object
        DrivingLicense license = new DrivingLicense();
        license.setId((long)(new Random().nextInt(50000)));
        license.setType("2 wheeler");
        license.setExpiryDate(LocalDateTime.of(2040, 10, 13, 12, 45));
        per.setDrivingLicense(license);
//        System.out.println(service.savePersonWithLicense(per));
        System.out.println(service.saveLicenseWithPerson(license));

    }
}

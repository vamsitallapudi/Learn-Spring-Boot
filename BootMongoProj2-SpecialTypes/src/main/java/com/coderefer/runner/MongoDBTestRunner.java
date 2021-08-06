package com.coderefer.runner;

import com.coderefer.document.PersonDetails;
import com.coderefer.service.IPersonDetailsMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class MongoDBTestRunner implements CommandLineRunner {

    @Autowired
    IPersonDetailsMgmtService service;

    @Override
    public void run(String... args) throws Exception {
        PersonDetails details = new PersonDetails();
        details.setPid(new Random().nextInt(100000));
        details.setPname("raja");
        details.setMaritalStatus(false);
        details.setPaddrs("hyd");
        details.setDob(LocalDateTime.of(1991, 3,2,18,45));
        details.setNickNames(new String[]{"raj", "king"});
        details.setMobileNos(Set.of(1234L, 5678L));
        details.setAcademics(List.of("10th", "12th", "BTech"));
        details.setBankAccounts(Map.of("ICICI", 235L, "HDFC", 2345L));
        Properties prop = new Properties();
        prop.put("aadhar", "3235456");
        prop.put("pan", "Ane3545L");
        details.setIdDetails(prop);
        System.out.println("Person saved with id: " + service.registerPerson(details).getPid());
    }
}

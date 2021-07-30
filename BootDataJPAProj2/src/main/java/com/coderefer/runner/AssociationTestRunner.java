package com.coderefer.runner;

import com.coderefer.entity.Person;
import com.coderefer.entity.PhoneNumber;
import com.coderefer.service.IPersonMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AssociationTestRunner implements CommandLineRunner {
    @Autowired
    IPersonMgmtService service;
    @Override
    public void run(String... args) throws Exception {
        PhoneNumber ph1 = new PhoneNumber(9876L, "airtel", "office");
        PhoneNumber ph2 = new PhoneNumber(9877L, "airtel", "office");
        Person person1 = new Person("vamsi", "hyd");
        ph1.setPerson(person1);
        ph2.setPerson(person1);
        Set<PhoneNumber> phones = Set.of(ph1,ph2);
        person1.setContactDetails(phones);
        System.out.println(service.savePerson(person1));
    }
}

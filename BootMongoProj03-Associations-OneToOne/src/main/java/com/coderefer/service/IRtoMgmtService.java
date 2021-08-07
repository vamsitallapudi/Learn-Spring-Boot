package com.coderefer.service;


import com.coderefer.document.DrivingLicense;
import com.coderefer.document.Person;

import java.util.List;

public interface IRtoMgmtService {
    String savePersonWithLicense(Person p);
    String saveLicenseWithPerson(DrivingLicense l);

    List<Person> fetchAllPersons();
}

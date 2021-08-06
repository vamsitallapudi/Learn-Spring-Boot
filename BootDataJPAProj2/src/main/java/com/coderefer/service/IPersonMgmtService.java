package com.coderefer.service;

import com.coderefer.entity.Person;
import com.coderefer.entity.PhoneNumber;

import java.util.List;

public interface IPersonMgmtService {
    Person savePerson(Person p);
    public List<Person> fetchByPerson();
    List<PhoneNumber> fetchByPhoneNumber();
    String deleteByPerson(Long personId);
    String deleteAllPhoneNoOfPerson(Long personId);
}

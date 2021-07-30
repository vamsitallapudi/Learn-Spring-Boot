package com.coderefer.service;

import com.coderefer.entity.Person;
import com.coderefer.repo.IPersonRepo;
import com.coderefer.repo.IPhoneNoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService{
    @Autowired
    IPersonRepo repo;
    @Autowired
    private IPhoneNoRepo phoneNoRepo;
    @Override
    public Person savePerson(Person p) {
        return repo.save(p);
    }
}

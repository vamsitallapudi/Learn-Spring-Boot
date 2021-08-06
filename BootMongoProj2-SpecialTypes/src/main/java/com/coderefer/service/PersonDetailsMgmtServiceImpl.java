package com.coderefer.service;

import com.coderefer.document.PersonDetails;
import com.coderefer.repo.IPersonDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDetailsMgmtServiceImpl implements IPersonDetailsMgmtService{
    @Autowired
    IPersonDetailsRepo repo;
    @Override
    public PersonDetails registerPerson(PersonDetails details) {
        return repo.save(details);
    }
}

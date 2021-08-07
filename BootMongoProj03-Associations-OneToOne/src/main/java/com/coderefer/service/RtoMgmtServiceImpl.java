package com.coderefer.service;

import com.coderefer.document.DrivingLicense;
import com.coderefer.document.Person;
import com.coderefer.repo.IDrivingLicenseRepo;
import com.coderefer.repo.IpersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rtoMgmtService")
public class RtoMgmtServiceImpl implements IRtoMgmtService {
    @Autowired
    private IpersonRepo repo;
    @Autowired
    private IDrivingLicenseRepo lRepo;

    @Autowired
    private IDrivingLicenseRepo licRepo;

    @Override
    public String savePersonWithLicense(Person p) {
        return "Person object having license is saved with id value ::" + repo.save(p).getPid();
    }

    @Override
    public String saveLicenseWithPerson(DrivingLicense l) {
        return "License object having person is saved with id value ::" + lRepo.save(l).getId();
    }

    @Override
    public List<Person> fetchAllPersons() {
        return repo.findAll();
    }

}

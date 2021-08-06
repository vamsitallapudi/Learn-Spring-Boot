package com.coderefer.service;

import com.coderefer.entity.Person;
import com.coderefer.entity.PhoneNumber;
import com.coderefer.repo.IPersonRepo;
import com.coderefer.repo.IPhoneNoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public List<Person> fetchByPerson() {
        return null;
    }

    @Override
    public List<PhoneNumber> fetchByPhoneNumber() {
        return null;
    }

    @Override
    public String deleteByPerson(Long personId) {
        return null;
    }

    @Override
    public String deleteAllPhoneNoOfPerson(Long personId) {
//        Load Parent Obj
        Optional<Person> opt = repo.findById(personId);

        if(opt.isPresent()) {
//            get all children of a parent
            Set<PhoneNumber> children = opt.get().getContactDetails();
//            delete all children
            children.forEach(it -> it.setPerson(null));
            phoneNoRepo.deleteAll(children);
            return  "Phone Numbers are deleted";
        }
        return personId + "Person not found";
    }
}

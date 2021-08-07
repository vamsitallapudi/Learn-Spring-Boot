package com.coderefer.repo;

import com.coderefer.document.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IpersonRepo extends MongoRepository<Person, Integer> {
}

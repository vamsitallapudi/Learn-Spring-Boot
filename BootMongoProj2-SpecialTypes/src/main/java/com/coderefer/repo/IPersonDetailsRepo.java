package com.coderefer.repo;

import com.coderefer.document.PersonDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPersonDetailsRepo extends MongoRepository<PersonDetails, Integer> {
}

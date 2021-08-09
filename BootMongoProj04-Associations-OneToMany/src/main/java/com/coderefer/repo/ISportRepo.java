package com.coderefer.repo;

import com.coderefer.document.Sport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISportRepo extends MongoRepository<Sport, Long> {
}

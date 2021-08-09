package com.coderefer.repo;

import com.coderefer.document.Medal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMedalRepo extends MongoRepository<Medal, String> {
}

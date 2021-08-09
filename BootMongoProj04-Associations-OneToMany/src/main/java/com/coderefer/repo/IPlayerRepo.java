package com.coderefer.repo;

import com.coderefer.document.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPlayerRepo extends MongoRepository<Player, Integer> {
}

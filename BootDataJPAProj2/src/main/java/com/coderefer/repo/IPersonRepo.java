package com.coderefer.repo;

import com.coderefer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personRepo")
public interface IPersonRepo extends JpaRepository<Person, Long> {
}

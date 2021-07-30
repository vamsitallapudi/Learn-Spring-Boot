package com.coderefer.repo;

import com.coderefer.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("phoneRepo")
public interface IPhoneNoRepo extends JpaRepository<PhoneNumber, Long> {

}

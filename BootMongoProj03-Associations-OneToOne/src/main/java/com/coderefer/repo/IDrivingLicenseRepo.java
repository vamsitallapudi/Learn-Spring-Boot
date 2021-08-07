package com.coderefer.repo;

import com.coderefer.document.DrivingLicense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDrivingLicenseRepo extends MongoRepository<DrivingLicense, Long> {
}

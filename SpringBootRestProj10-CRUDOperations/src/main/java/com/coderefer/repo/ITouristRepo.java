package com.coderefer.repo;

import com.coderefer.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}

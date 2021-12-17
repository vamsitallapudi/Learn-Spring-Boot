package com.nt.repo;

import com.nt.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}

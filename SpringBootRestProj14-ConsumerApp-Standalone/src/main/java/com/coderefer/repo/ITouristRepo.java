package com.coderefer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderefer.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist,Integer> {

}

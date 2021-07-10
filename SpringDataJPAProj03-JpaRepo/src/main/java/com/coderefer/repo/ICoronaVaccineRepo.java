package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

}

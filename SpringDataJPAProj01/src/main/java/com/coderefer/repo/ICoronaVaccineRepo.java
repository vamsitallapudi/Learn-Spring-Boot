package com.coderefer.repo;


import org.springframework.data.repository.CrudRepository;

import com.coderefer.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long>{

}

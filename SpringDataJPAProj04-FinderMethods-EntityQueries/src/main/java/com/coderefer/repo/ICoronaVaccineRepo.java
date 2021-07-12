package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

//    SELECT REGNO, NAME, COMPANY, PRICE, COUNTRY,
//    REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COMPANY = ?;
    List<CoronaVaccine> findByCompany(String company);
    List<CoronaVaccine> findByCompanyEquals(String company);

}

package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

//    SELECT REGNO, NAME, COMPANY, PRICE, COUNTRY,
//    REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COMPANY = ?;
    List<CoronaVaccine> findByCompany(String company);
    List<CoronaVaccine> findByCompanyEquals(String company);
//    List<CoronaVaccine> findByPriceLessThan()
    List<CoronaVaccine> findByPriceBetween(Double start, Double end);
//   select coronavacc0_.reg_no as reg_no1_0_, coronavacc0_.company as company2_0_, coronavacc0_.country as country3_0_, coronavacc0_.name as name4_0_, coronavacc0_.price as price5_0_, coronavacc0_.required_dose_count as required6_0_ from corona_vaccine coronavacc0_ where coronavacc0_.name like ? escape ?
    List<CoronaVaccine> findByNameStartingWith(String start);
    //    SELECT REGNO, NAME, COMPANY, PRICE, COUNTRY,
//    REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME = ?;
    List<CoronaVaccine> findByNameEndingWith(String end);
    List<CoronaVaccine> findByNameContaining(String letters);
    List<CoronaVaccine> findByCountryIn(List<String> countries);
    List<CoronaVaccine> findByCountryNotIn(List<String> countries);
    List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(Double price);
}

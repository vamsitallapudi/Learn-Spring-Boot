package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
    //     @Query("FROM CoronaVaccine WHERE company=?1") //-> works
//     @Query("FROM CoronaVaccine as cv WHERE cv.company=?1") throws -> java.lang.IllegalArgumentException
//     @Query("FROM CoronaVaccine as cv WHERE cv.company=?1") //-> works
    /*
    * @Query("FROM CoronaVaccine WHERE company=:vendor") //-> works
     List<CoronaVaccine> searchVaccinesByCompany(String vendor);
    * */

//   =================== SELECT QUERIES PERFORMING BULK OPERATIONS =============================
    @Query("FROM CoronaVaccine WHERE company=:comp")//-> works
    List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);
    @Query("FROM CoronaVaccine WHERE price >=:min and price <=:max")//-> works
    List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max);
    @Query("FROM CoronaVaccine WHERE price >=?2 and price <=?1")//-> works
    List<CoronaVaccine> searchVaccinesByPriceRangeByNumberedParam(double min, double max);
    @Query("FROM CoronaVaccine WHERE company IN (:comp1, :comp2, :comp3) ORDER BY company")
    List<CoronaVaccine> searchVaccinesByCompanies(String comp1, String comp2, String comp3);


    @Query("select name, company, price FROM CoronaVaccine WHERE name IN (:name1, :name2) ORDER BY company")
    List<Object[]> searchVaccinesByNames(String name1, String name2);

//   =================== SELECT QUERIES PERFORMING SINGLE ROW OPERATIONS =============================
//    Entity Query giving single row
    @Query("FROM CoronaVaccine WHERE name=:name")
    Optional<CoronaVaccine> searchVaccineByName(String name);

    @Query("SELECT name, company, country FROM CoronaVaccine where name=:name")
    Object searchVaccineDataByName(String name);
}

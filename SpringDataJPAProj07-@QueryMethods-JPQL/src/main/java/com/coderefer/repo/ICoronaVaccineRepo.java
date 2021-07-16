package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
    //     @Query("FROM CoronaVaccine WHERE company=?1") //-> works
//     @Query("FROM CoronaVaccine as cv WHERE cv.company=?1") throws -> java.lang.IllegalArgumentException
//     @Query("FROM CoronaVaccine as cv WHERE cv.company=?1") //-> works
    /*
    * @Query("FROM CoronaVaccine WHERE company=:vendor") //-> works
     List<CoronaVaccine> searchVaccinesByCompany(String vendor);
    * */
    @Query("FROM CoronaVaccine WHERE company=:comp")
    //-> works
    List<CoronaVaccine> searchVaccinesByCompany(@Param("comp") String vendor);
}

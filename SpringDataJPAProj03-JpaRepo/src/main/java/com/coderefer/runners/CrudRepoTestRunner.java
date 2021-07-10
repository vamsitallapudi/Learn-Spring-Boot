package com.coderefer.runners;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    private final ICoronaVaccineMgmtService service;

    @Autowired
    public CrudRepoTestRunner(ICoronaVaccineMgmtService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        try {
            CoronaVaccine vaccine = new CoronaVaccine();
            vaccine.setName("pfizer");
//            CoronaVaccine vaccine = new CoronaVaccine("covaxin","Bharat Biotech","India",749.0,2);
            service.searchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);
        }catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

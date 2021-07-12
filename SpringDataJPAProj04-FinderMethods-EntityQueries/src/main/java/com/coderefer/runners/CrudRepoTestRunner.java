package com.coderefer.runners;

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
            service.fetchVaccinesByCompany("pfizer").forEach(System.out::println);
            service.fetchVaccinesByCompanyEquals("Bharat Biotech").forEach(System.out::println);
        }catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

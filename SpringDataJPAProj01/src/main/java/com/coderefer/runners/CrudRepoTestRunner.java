package com.coderefer.runners;

import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    @Autowired
    private ICoronaVaccineMgmtService service;

    @Override
    public void run(String... args) throws Exception {

        try {
            System.out.println("Total records count: " + service.getVaccinesCount());
            System.out.println("5 Vaccine available? " + service.checkVaccineAvailability(5));
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

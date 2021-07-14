package com.coderefer.runners;

import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
            service.searchVaccinesByStartPrice(600).forEach(
                    it -> {
                        System.out.println(it.getClass());
                        System.out.println(Arrays.toString(it.getClass().getDeclaredMethods()));
                        System.out.println(it.getCountry() + " " + it.getName());
                    });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

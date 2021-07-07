package com.coderefer.runners;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    @Autowired
    private ICoronaVaccineMgmtService service;

    @Override
    public void run(String... args) throws Exception {

        try {
            System.out.println("Total records count: " + service.getVaccinesCount());
            System.out.println("5 Vaccine available? " + service.checkVaccineAvailability(5));
            System.out.println("===================findAll()========================");
            List<CoronaVaccine> vaccineList = service.fetchAllDetails();
            service.fetchAllDetails().stream().forEach(System.out::println); //testing java8 streams
            System.out.println("====================================================");
            System.out.println();
            System.out.println("===================findAllByIds()===================");
            service.fetchAllDetailsById(Arrays.asList(3L, 4L, 5L)).forEach(System.out::println);
            System.out.println("====================================================");

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

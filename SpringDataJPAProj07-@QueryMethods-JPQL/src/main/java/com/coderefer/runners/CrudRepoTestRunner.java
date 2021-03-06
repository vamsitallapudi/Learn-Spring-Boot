package com.coderefer.runners;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    private final ICoronaVaccineMgmtService service;

    @Autowired
    public CrudRepoTest
    Runner(ICoronaVaccineMgmtService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        try {
            service.fetchVaccinesByCompany("Russie").forEach(System.out::println);
            System.out.println("################# finding vaccines by price range ###########################");
            service.fetchVaccinesByPriceRange(700.0, 1500.0).forEach(System.out::println);
            System.out.println("################# finding vaccines by companies ###########################");
            service.fetchVaccinesByCompanies("Russie", "Moderena", "pfizer").forEach(System.out::println);
            System.out.println("################# finding vaccines data by name ###########################");
            service.fetchVaccinesDataByNames("covaxin", "Sputnik").forEach(it -> Arrays.stream(it).forEach(System.out::println));
            System.out.println();
            System.out.println("################# Single Row Operations ###########################");
            System.out.println();
            System.out.println("################# fetch vaccine by name ###########################");
            Optional<CoronaVaccine> opt = service.fetchVaccineByName("Sputnik");
            opt.ifPresent(System.out::println);
            System.out.println("################# fetch vaccine data by name ###########################");
            Object obj = service.fetchVaccineDataByName("Sputnik");
            Arrays.stream((Object[]) obj).forEach(System.out::println);
            System.out.println("################# fetch vaccine by country name ###########################");
            System.out.println(service.fetchVaccineByCountryName("Russia"));
            System.out.println();
            System.out.println("################# Aggregates ###########################");
            System.out.println();
            System.out.println("################# get count ###########################");
            System.out.println(service.fetchVaccinesCount());
            System.out.println("################# get vaccine aggregate ###########################");
            Arrays.stream((Object[])service.getVaccinesAggregate(400.0, 600.0)).forEach(System.out::println);
            System.out.println();

            System.out.println("################# Native SQL Queries ###########################");
//            int count = service.registerVaccine(1001L, "serum", "India", "Sinopharm", 200.0, 1);
//            if(count == 0) {
//                System.out.println("Record not inserted");
//            } else {
//                System.out.println("Record Inserted");
//            }
            System.out.println("######## Printing Date ########");
            System.out.println(service.getSysDate());
            System.out.println("#######################");


        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

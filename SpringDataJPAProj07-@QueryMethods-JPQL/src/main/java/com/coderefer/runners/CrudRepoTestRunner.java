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
    public CrudRepoTestRunner(ICoronaVaccineMgmtService service) {
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
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

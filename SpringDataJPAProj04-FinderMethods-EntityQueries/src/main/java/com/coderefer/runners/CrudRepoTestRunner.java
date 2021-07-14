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
//            service.fetchVaccinesByCompany("pfizer").forEach(System.out::println);
//            service.fetchVaccinesByCompanyEquals("Bharat Biotech").forEach(System.out::println);
//            service.fetchVaccineByPriceRange(0.0,500.0).forEach(System.out::println);
            System.out.println("############### starts with ######################");
            service.findVaccinesByNameStartsWith("s").forEach(System.out::println);
            System.out.println("############### ending with ######################");
            service.findVaccinesByNameEndingWith("na").forEach(System.out::println);
            System.out.println("############### containing ######################");
            service.fetchVaccinesByNameContaining("e").forEach(System.out::println);
            System.out.println("############### Countries in ######################");
            service.fetchVaccinesByCountries("India", "Russia").forEach(System.out::println);
            System.out.println("############### Countries not in ######################");
            service.fetchVaccinesByCountriesNotIn("India", "Russia").forEach(System.out::println);
            System.out.println("############### order by price asc ######################");
            service.findPriceGreaterThanOrderByPriceAsc(500.0).forEach(System.out::println);
            System.out.println("############### find By name and ID ######################");
            service.searchVaccinesByNameAndCountry("pfizer", "USA").forEach(System.out::println);
            System.out.println("############### find By name like or Price between ######################");
            service.searchVaccineByNameLikeOrPriceBetween("%co%", 400.0, 600.0).forEach(System.out::println);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

package com.coderefer.runner;

import com.coderefer.service.IVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StoredProcedureRunner implements CommandLineRunner {
    @Autowired
    private IVaccineMgmtService service;

    @Override
    public void run(String... args) throws Exception {
//        service.searchVaccineByPriceRange(400.0,900.0).forEach(System.out::println);
//        service.getVaccineByName("covaxin").forEach(System.out::println);
        service.getEmpDetailsByCompany("Amazon", "HCL").forEach(System.out::println);
    }
}

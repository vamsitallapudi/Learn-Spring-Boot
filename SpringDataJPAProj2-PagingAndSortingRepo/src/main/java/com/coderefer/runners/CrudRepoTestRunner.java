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
    public void run(String... args) throws Exception {

        try {
//            fetching Details in ascending order based on a property
//          service.fetchDetails(true, "price");
//          Fetching details with Page Number and page size
            service.fetchDetailsByPage(0, 2, true, "price" ).forEach(System.out::println);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

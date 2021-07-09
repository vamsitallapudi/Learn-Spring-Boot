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
//          service.fetchDetails(true, "price");
//            service.fetchDetailsByPage(0, 2, true, "price" ).forEach(System.out::println);

            service.fetchDetailsByPagination(5);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

package com.coderefer.runners;

import com.coderefer.entity.CoronaVaccine;
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
            CoronaVaccine vaccine = new CoronaVaccine(
                    "Covishield", "Serum", "India", 500.2, 2);
            System.out.println(service.registerVaccine(vaccine));
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.coderefer.runners;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

    @Autowired
    private ICoronaVaccineMgmtService service;

    @Override
    public void run(String... args) throws Exception {

        try {
            //        Bulk Insertion / Batch Insertion
            List<CoronaVaccine> list = service.registerInBatch(List.of(
                    new CoronaVaccine("Sputnik", "Russie", "Russia", 567.0, 2),
                    new CoronaVaccine("pfizer", "pfizer", "USA", 1400.0, 2),
                    new CoronaVaccine("moderena", "Moderena", "USA", 455.5, 2)
            ));

            System.out.println(list.size());
            list.forEach(v -> System.out.println(v.getRegNo()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

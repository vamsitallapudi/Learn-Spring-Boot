package com.coderefer.runners;

import com.coderefer.service.ICoronaVaccineMgmtService;
import com.coderefer.type.ResultView;
import com.coderefer.type.ResultView2;
import com.coderefer.type.ResultView3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

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
            System.out.println("######################### ResultView ###########################");
            List<ResultView> list1 = service.searchVaccinesByCompany("Russie", ResultView.class);
            list1.forEach(v1-> System.out.println(v1.getName() + " " + v1.getCountry()));
            System.out.println("######################### ResultView2 ###########################");
            List<ResultView2> list2 = service.searchVaccinesByCompany("pfizer", ResultView2.class);
            list2.forEach(v2 -> System.out.println(v2.getRegNo() + " " + v2.getPrice()));
            System.out.println("####################### ResultView3 ##############################");
            service.searchVaccinesByCompany("Bharat Biotech", ResultView3.class)
                    .forEach(v3 -> System.out.println(v3.getPrice() + " " + v3.getRequiredDoseCount()));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

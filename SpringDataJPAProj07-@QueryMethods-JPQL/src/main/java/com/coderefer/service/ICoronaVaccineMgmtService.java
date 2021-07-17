package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {
    List<CoronaVaccine> fetchVaccinesByCompany(String vendor);
    List<CoronaVaccine> fetchVaccinesByPriceRange(Double minPrice, Double maxPrice);
    List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2, String comp3);

    List<Object[]> fetchVaccinesDataByNames(String name1, String name2);

}

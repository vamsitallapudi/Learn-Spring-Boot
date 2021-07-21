package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtService {
    List<CoronaVaccine> fetchVaccinesByCompany(String vendor);
    List<CoronaVaccine> fetchVaccinesByPriceRange(Double minPrice, Double maxPrice);
    List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2, String comp3);

    List<Object[]> fetchVaccinesDataByNames(String name1, String name2);
    Optional<CoronaVaccine> fetchVaccineByName(String name);
    Object fetchVaccineDataByName(String name);
    String fetchVaccineByCountryName(String country);
    Long fetchVaccinesCount();
    Object getVaccinesAggregate(Double minPrice, Double maxPrice);
    int modifyVaccinePriceByCountry(double newPrice, String country);
    int removeVaccineByPriceRange(double starPrice, double endPrice);
    int registerVaccine(long regNo, String company, String country, String name, Double price, int dose);
    Date getSysDate();

}

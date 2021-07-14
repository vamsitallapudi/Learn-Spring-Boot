package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {

    public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean asc, String... properties);
    public CoronaVaccine getVaccineByRegNo(Long regId);
    public String removeVaccinesByRegNos(List<Long> regNos);

    List<CoronaVaccine> fetchVaccinesByCompany(String company);
    List<CoronaVaccine> fetchVaccinesByCompanyEquals(String company);
    List<CoronaVaccine> fetchVaccineByPriceRange(Double start, Double end);
    List<CoronaVaccine> findVaccinesByNameStartsWith(String startLetters);
    List<CoronaVaccine> findVaccinesByNameEndingWith(String endingLetters);
    List<CoronaVaccine> fetchVaccinesByNameContaining(String letters);
    List<CoronaVaccine> fetchVaccinesByCountries(String... country);
    List<CoronaVaccine> fetchVaccinesByCountriesNotIn(String... country);
    List<CoronaVaccine> findPriceGreaterThanOrderByPriceAsc(Double price);
    List<CoronaVaccine> searchVaccinesByNameAndCountry(String name, String country);
    List<CoronaVaccine> searchVaccineByNameLikeOrPriceBetween(String nameLike, Double priceStart, Double priceEnd);
}

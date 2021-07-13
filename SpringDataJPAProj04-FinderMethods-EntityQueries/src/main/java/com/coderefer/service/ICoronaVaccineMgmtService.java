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
}

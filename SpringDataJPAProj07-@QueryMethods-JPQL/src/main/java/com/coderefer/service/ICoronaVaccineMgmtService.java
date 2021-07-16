package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {
    List<CoronaVaccine> fetchVaccinesByCompany(String vendor);

}

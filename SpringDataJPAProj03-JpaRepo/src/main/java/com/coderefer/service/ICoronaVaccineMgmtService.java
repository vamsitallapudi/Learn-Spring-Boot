package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {

    public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean asc, String... properties);

}

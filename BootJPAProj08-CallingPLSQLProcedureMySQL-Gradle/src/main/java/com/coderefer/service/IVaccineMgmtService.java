package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface IVaccineMgmtService {
    List<CoronaVaccine> searchVaccineByPriceRange(double min, double max);
}

package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.entity.Employee;

import java.util.List;

public interface IVaccineMgmtService {
    List<CoronaVaccine> searchVaccineByPriceRange(double min, double max);
    List<CoronaVaccine> getVaccineByName(String name);
    List<Employee> getEmpDetailsByCompany(String company1, String company2);
}

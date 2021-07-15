package com.coderefer.service;

import com.coderefer.type.View;

import java.util.List;

public interface ICoronaVaccineMgmtService {
    <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> myClass);
}

package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {
	String registerVaccine(CoronaVaccine vaccine);
	List<CoronaVaccine> registerInBatch(List<CoronaVaccine> vaccines);
	long getVaccinesCount();
	boolean checkVaccineAvailability(long regNo);
	List<CoronaVaccine> fetchAllDetails();
	List<CoronaVaccine> fetchAllDetailsById(List<Long> ids);
}

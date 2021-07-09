package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;
import java.util.Optional;

public interface ICoronaVaccineMgmtService {
	String registerVaccine(CoronaVaccine vaccine);
	List<CoronaVaccine> registerInBatch(List<CoronaVaccine> vaccines);
	long getVaccinesCount();
	boolean checkVaccineAvailability(long regNo);
	List<CoronaVaccine> fetchAllDetails();
	List<CoronaVaccine> fetchAllDetailsById(List<Long> ids);
	Optional<CoronaVaccine> fetchById(Long id);
	String removeVaccineById(Long id);
}

package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {
	String registerVaccine(CoronaVaccine vaccine);
	List<CoronaVaccine> registerInBatch(List<CoronaVaccine> vaccines);
	long getVaccinesCount();
	public boolean checkVaccineAvailability(long regNo);
}

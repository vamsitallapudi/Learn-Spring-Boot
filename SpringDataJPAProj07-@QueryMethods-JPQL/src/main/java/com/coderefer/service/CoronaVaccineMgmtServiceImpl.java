package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.repo.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	private final ICoronaVaccineRepo  coronaRepo;

	@Autowired
	public CoronaVaccineMgmtServiceImpl(ICoronaVaccineRepo coronaRepo) {
		this.coronaRepo = coronaRepo;
	}


	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String vendor) {
		return coronaRepo.searchVaccinesByCompany(vendor);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceRange(Double minPrice, Double maxPrice) {
//		return coronaRepo.searchVaccinesByPriceRangeByNumberedParam(minPrice, maxPrice);
		return coronaRepo.searchVaccinesByPriceRange(minPrice, maxPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2, String comp3) {
		return coronaRepo.searchVaccinesByCompanies(comp1, comp2, comp3);
	}

	@Override
	public List<Object[]> fetchVaccinesDataByNames(String name1, String name2) {
		return coronaRepo.searchVaccinesByNames(name1, name2);
	}
}
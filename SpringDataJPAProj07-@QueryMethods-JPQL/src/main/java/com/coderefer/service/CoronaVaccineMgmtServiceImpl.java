package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.repo.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


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

	@Override
	public Optional<CoronaVaccine> fetchVaccineByName(String name) {
		return coronaRepo.searchVaccineByName(name);
	}

	@Override
	public Object fetchVaccineDataByName(String name) {
		return coronaRepo.searchVaccineDataByName(name);
	}

	@Override
	public String fetchVaccineByCountryName(String country) {
		return coronaRepo.searchVaccineByCountryName(country);
	}

	@Override
	public Long fetchVaccinesCount() {
		return coronaRepo.getVaccinesCount();
	}

	@Override
	public Object getVaccinesAggregate(Double minPrice, Double maxPrice) {
		return coronaRepo.getVaccinesAggregateByPriceRange(minPrice,maxPrice);
	}

	@Override
	@Transactional
	public int modifyVaccinePriceByCountry(double newPrice, String country) {
		return coronaRepo.updatePriceByCountry(newPrice,country);
	}

	@Override
	public int removeVaccineByPriceRange(double startPrice, double endPrice) {
		return coronaRepo.removeVaccineByPriceRange(startPrice, endPrice);
	}

	@Override
	public int registerVaccine(long regNo, String company, String country, String name, Double price, int dose) {
		return coronaRepo.insertVaccine(regNo, company, country, name, price, dose);
	}
}
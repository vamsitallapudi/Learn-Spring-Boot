package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.repo.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
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
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean asc, String... properties) {
//		Prepare Example object
		Example<CoronaVaccine> coronaVaccineExample = Example.of(vaccine);
		Sort sort = Sort.by(asc? Sort.Direction.ASC : Sort.Direction.DESC, properties);
		return coronaRepo.findAll(coronaVaccineExample, sort);
	}

	@Override
	public CoronaVaccine getVaccineByRegNo(Long regId) {
		return coronaRepo.getById(regId);
	}

	@Override
	public String removeVaccinesByRegNos(List<Long> regNos) {
		List<CoronaVaccine> listEntities = coronaRepo.findAllById(regNos);
		if(listEntities.size() != 0) {
			coronaRepo.deleteAllByIdInBatch(regNos);
			return listEntities.size() + " No. of records are deleted";
		}
		return "Records not found to delete.";
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		return coronaRepo.findByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanyEquals(String company) {
		return coronaRepo.findByCompanyEquals(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByPriceRange(Double start, Double end) {
		return coronaRepo.findByPriceBetween(start, end);
	}

	@Override
	public List<CoronaVaccine> findVaccinesByNameStartsWith(String startLetters) {
		return coronaRepo.findByNameStartingWith(startLetters);
	}

	@Override
	public List<CoronaVaccine> findVaccinesByNameEndingWith(String endingLetters) {
		return coronaRepo.findByNameEndingWith(endingLetters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByNameContaining(String letters) {
		return coronaRepo.findByNameContaining(letters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountries(String... countries) {
		List<String> myCon = List.of(countries);
		return coronaRepo.findByCountryIn(myCon);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCountriesNotIn(String... countries) {
		return coronaRepo.findByCountryNotIn(List.of(countries));
	}

	@Override
	public List<CoronaVaccine> findPriceGreaterThanOrderByPriceAsc(Double price) {
		return coronaRepo.findByPriceGreaterThanOrderByPriceAsc(price);
	}

	@Override
	public List<CoronaVaccine> searchVaccinesByNameAndCountry(String name, String country) {
		return coronaRepo.findByNameAndCountry(name, country);
	}

	@Override
	public List<CoronaVaccine> searchVaccineByNameLikeOrPriceBetween(String nameLike, Double priceStart, Double priceEnd) {
		return coronaRepo.findByNameLikeOrPriceBetween(nameLike, priceStart, priceEnd);
	}
}
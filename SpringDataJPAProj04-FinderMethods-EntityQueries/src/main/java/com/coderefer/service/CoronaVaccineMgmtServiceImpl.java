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
}
package com.coderefer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.repo.ICoronaVaccineRepo;

import java.util.List;
import java.util.Optional;


@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo  coronaRepo;

	@Override
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("InMemory Proxy class name ::"+coronaRepo.getClass());
		//use  repo
		CoronaVaccine savedVaccine=null;
		  if(vaccine!=null)
		    savedVaccine=coronaRepo.save(vaccine);
		return savedVaccine!=null?"Vaccine registered/updated successfully with "+savedVaccine.getRegNo():" Vaccine registration/updation failed";
	}

	@Override
	public List<CoronaVaccine> registerInBatch(List<CoronaVaccine> vaccines) {
		if(vaccines != null)
			return (List<CoronaVaccine>) coronaRepo.saveAll(vaccines);
		else
			throw new IllegalArgumentException("Passed vaccines are null");
	}

	@Override
	public long getVaccinesCount() {
		return coronaRepo.count();
	}

	@Override
	public boolean checkVaccineAvailability(long regNo) {
		return coronaRepo.existsById(regNo);
	}

	@Override
	public List<CoronaVaccine> fetchAllDetails() {
		return (List<CoronaVaccine>) coronaRepo.findAll();
	}

	@Override
	public List<CoronaVaccine> fetchAllDetailsById(List<Long> ids) {
		return (List<CoronaVaccine>) coronaRepo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchById(Long id) {
		return coronaRepo.findById(id);
	}

}
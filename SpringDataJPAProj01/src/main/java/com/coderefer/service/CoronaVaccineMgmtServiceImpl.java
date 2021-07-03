package com.coderefer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.repo.ICoronaVaccineRepo;


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

}
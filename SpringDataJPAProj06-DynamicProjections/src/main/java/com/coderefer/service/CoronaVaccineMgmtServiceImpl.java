package com.coderefer.service;

import com.coderefer.repo.ICoronaVaccineRepo;
import com.coderefer.type.View;
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
	public <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> myClass) {
		return coronaRepo.findByCompanyOrderByCompanyDesc(company, myClass);
	}
}
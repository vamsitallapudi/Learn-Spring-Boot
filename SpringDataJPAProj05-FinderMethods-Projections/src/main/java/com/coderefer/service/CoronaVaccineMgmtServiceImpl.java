package com.coderefer.service;

import com.coderefer.repo.ICoronaVaccineRepo;
import com.coderefer.type.ResultView;
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
	public List<ResultView> searchVaccinesByStartPrice(double startPrice) {
		return coronaRepo.findByPriceGreaterThanEqualOrderByPrice(startPrice);
	}
}
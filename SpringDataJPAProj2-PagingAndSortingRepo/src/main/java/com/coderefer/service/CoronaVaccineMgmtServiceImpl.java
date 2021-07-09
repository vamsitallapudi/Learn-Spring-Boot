package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.repo.ICoronaVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo  coronaRepo;


	@Override
	public List<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		Sort sort = Sort.by(asc? Sort.Direction.ASC : Sort.Direction.DESC,properties);
		try {
			List<CoronaVaccine> vaccineList = coronaRepo.findAll(sort);
			vaccineList.forEach(System.out::println);
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CoronaVaccine> fetchDetailsByPage(int pageNo, int pageSize, boolean asc, String... properties) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc? Sort.Direction.ASC : Sort.Direction.DESC, properties );
		Page<CoronaVaccine> page = coronaRepo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		long count = coronaRepo.count();
//		decide the pagesCount
		long pagesCount = count/pageSize;
		pagesCount = count %pageSize ==0 ? pagesCount: ++pagesCount;
		for(int i = 0 ; i< pagesCount; ++i) {
			Pageable pageable = PageRequest.of(i,pageSize);
			Page<CoronaVaccine> page = coronaRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("==============="+(i+1) + " of " + page.getTotalPages()+"===============");
		}
	}
}
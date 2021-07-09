package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineMgmtService {
    List<CoronaVaccine> fetchDetails(boolean asc, String... properties);

    List<CoronaVaccine> fetchDetailsByPage(int pageNo, int pageSize, boolean asc, String... properties);

    void fetchDetailsByPagination(int pageSize);
}

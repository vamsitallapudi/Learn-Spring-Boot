package com.coderefer.service;

import com.coderefer.type.ResultView;

import java.util.List;

public interface ICoronaVaccineMgmtService {
    List<ResultView> searchVaccinesByStartPrice(double startPrice);
}

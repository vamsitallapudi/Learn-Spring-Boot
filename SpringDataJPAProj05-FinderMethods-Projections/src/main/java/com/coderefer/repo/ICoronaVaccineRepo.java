package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import com.coderefer.type.ResultView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
    List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double startPrice);
}

package com.coderefer.repo;


import com.coderefer.entity.CoronaVaccine;
import com.coderefer.type.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICoronaVaccineRepo  extends JpaRepository<CoronaVaccine, Long> {
//    List<? extends View> void findByCompanyOrderByCompanyDesc(String startPrice, Class<?> myClass);
     <T extends View> List<T> findByCompanyOrderByCompanyDesc(String startPrice, Class<T> myClass);
}

package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service("vaccineService")
public class VaccineMgmtServiceImpl implements IVaccineMgmtService{
    @Autowired
    private EntityManager manager;

    @Override
    public List<CoronaVaccine> searchVaccineByPriceRange(double min, double max) {
        StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_VACCINES_BY_PRICE_RANGE", CoronaVaccine.class);
//        register params of PL/SQL Procedure
        query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, CoronaVaccine.class, ParameterMode.REF_CURSOR);
//        set values to params
        query.setParameter(1, min);
        query.setParameter(2, max);
//        call PL/SQL Procedure
        List<CoronaVaccine> list = query.getResultList();
        return list;
    }
}

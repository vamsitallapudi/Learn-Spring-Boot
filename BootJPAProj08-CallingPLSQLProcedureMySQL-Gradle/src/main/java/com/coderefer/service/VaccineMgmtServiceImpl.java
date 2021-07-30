package com.coderefer.service;

import com.coderefer.entity.CoronaVaccine;
import com.coderefer.entity.Employee;
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

    @Override
    public List<CoronaVaccine> getVaccineByName(String name) {
//        create StoredProcedureQuery object
        StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_VACCINE_BY_NAME", Employee.class);
//        register params
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
//        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
//        query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
//        set param values
        query.setParameter(1, name);
//        call the procedure
        query.execute();
//        gather results from out param
        return (List<CoronaVaccine>) query.getResultList();
    }

    @Override
    public List<Employee> getEmpDetailsByCompany(String company1, String company2) {
        StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_EMPDETAILS_BY_DESGS");

//        register params
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

//        set param values
        query.setParameter(1, company1);
        query.setParameter(2, company2);
//        call the procedure
        query.execute();
        return (List<Employee>) query.getResultList();
    }


}

package com.coderefer.dao;

import java.util.List;

import com.coderefer.bo.EmployeeBO;

public interface IEmployeeDAO {
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception;
}

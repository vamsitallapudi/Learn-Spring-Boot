package com.coderefer.service;

import java.util.List;

import com.coderefer.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO> fetchEmpsByDesg(String desg[]) throws Exception;
}

package com.coderefer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderefer.bo.EmployeeBO;
import com.coderefer.dao.IEmployeeDAO;
import com.coderefer.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl  implements IEmployeeMgmtService{
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesg(String desg[]) throws Exception {
		String cond = null;
		// convert desgs[] into sql in clause string condition ('Technical Lead')
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for(int i = 0; i< desg.length; ++i) {
			if(i == desg.length-1) {
				sb.append("'" + desg[i] + "')");
			} else {
				sb.append("'" + desg[i] + "',");
			}
		}
		cond = sb.toString();
		
//		use DAO
		List<EmployeeBO> listBO = dao.getEmpsByDesg(cond);
//		convert ListBO to ListDTO
		List<EmployeeDTO> listDTO = new ArrayList<>();
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
//			copy each BO class obj to each DTO class obj
			BeanUtils.copyProperties(bo, dto); // property names and type must match in both java beans
			dto.setSrNo(listDTO.size() + 1);
//			 add each obj of DTO class to List DTO
			listDTO.add(dto);
		});
		
		return listDTO;
	}

}

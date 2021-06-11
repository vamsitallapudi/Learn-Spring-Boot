package com.coderefer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.coderefer.dto.EmployeeDTO;
import com.coderefer.service.IEmployeeMgmtService;
import com.coderefer.vo.EmployeeVO;

@Controller("controller")
public class MainController {

	@Autowired
	private IEmployeeMgmtService service;
	
	public List<EmployeeVO> showEmpsByDesg(String desg[]) throws Exception {
		
		List<EmployeeDTO> listDTO = service.fetchEmpsByDesg(desg);
		List<EmployeeVO> listVO = new ArrayList<>();
		listDTO.forEach(dto -> {
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			listVO.add(vo);
		});
		
		
		return listVO;
		
	}
}

package com.fengqiliu.test.webapp.service;

import java.util.List;

import com.fengqiliu.test.webapp.model.Emp;

public interface EmpService {
	
	public Emp getEmpById(Long empId);
	
	public List<Emp> getEmpList();

}

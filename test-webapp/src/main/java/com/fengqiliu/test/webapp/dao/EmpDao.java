package com.fengqiliu.test.webapp.dao;

import java.util.List;

import com.fengqiliu.test.webapp.model.Emp;


public interface EmpDao {
	
	public Emp getById(Long empId);

	public List<Emp> getEmpList();
	
	
}

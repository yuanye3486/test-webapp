package com.fengqiliu.test.webapp.dao;

import com.fengqiliu.test.webapp.model.Emp;

import java.util.List;


public interface EmpDao {

    public Emp getById(Long empId);

    public List<Emp> getEmpList();


}

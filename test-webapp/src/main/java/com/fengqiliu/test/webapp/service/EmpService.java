package com.fengqiliu.test.webapp.service;

import com.fengqiliu.test.webapp.model.Emp;

import java.util.List;

public interface EmpService {

    public Emp getEmpById(Long empId);

    public List<Emp> getEmpList();

}

package com.fengqiliu.test.webapp.service;

import com.fengqiliu.test.webapp.dao.EmpDao;
import com.fengqiliu.test.webapp.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public Emp getEmpById(Long empId) {
        return empDao.getById(empId);
    }

    @Override
    public List<Emp> getEmpList() {
        return empDao.getEmpList();
    }


}

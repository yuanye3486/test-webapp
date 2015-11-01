package com.fengqiliu.test.webapp.dao;

import com.fengqiliu.test.webapp.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Emp getById(Long empId) {
        return hibernateTemplate.get(Emp.class, empId);
    }

    @Override
    public List<Emp> getEmpList() {
        return hibernateTemplate.loadAll(Emp.class);
    }

}

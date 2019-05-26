package com.atguigu.provider.service.impl;

import com.atguigu.common.entity.Department;
import com.atguigu.provider.dao.DepartmentDao;
import com.atguigu.provider.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao deptDao;


    @Override
    public Department getById(Integer id) {
        return deptDao.getById(id);
    }

    @Override
    public boolean save(Department dept) {
        return deptDao.save(dept);
    }

    @Override
    public List<Department> findAll() {
        return deptDao.findAll();
    }
}

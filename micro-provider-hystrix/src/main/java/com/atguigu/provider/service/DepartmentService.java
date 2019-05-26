package com.atguigu.provider.service;

import com.atguigu.common.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department getById(Integer id);

    public boolean save(Department dept);

    public List<Department> findAll();
}

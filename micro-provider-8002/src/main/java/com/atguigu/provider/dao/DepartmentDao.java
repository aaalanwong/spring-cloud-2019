package com.atguigu.provider.dao;

import com.atguigu.common.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

    public Department getById(Integer id);

    public boolean save(Department dept);

    public List<Department> findAll();
}

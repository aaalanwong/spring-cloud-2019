package com.atguigu.provider.controller;

import com.atguigu.common.entity.Department;
import com.atguigu.provider.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private DepartmentService deptService;

    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id) {
        return deptService.getById(id);
    }

    @PostMapping("/dept")
    public boolean save(@RequestBody Department dept) {
        return deptService.save(dept);
    }

    @GetMapping("/dept")
    public List<Department> list() {
        return deptService.findAll();
    }


}

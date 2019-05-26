package com.atguigu.provider.controller;

import com.atguigu.common.entity.Department;
import com.atguigu.provider.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private DepartmentService deptService;

    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "hystrixCommandGet")
    public Department get(@PathVariable("id") Integer id) {
        Department dept = deptService.getById(id);
        if (dept == null){
            throw new RuntimeException();
        }
        return dept;
    }

    @PostMapping("/dept")
    public boolean save(@RequestBody Department dept) {
        return deptService.save(dept);
    }

    @GetMapping("/dept")
    public List<Department> list() {
        return deptService.findAll();
    }

    public Department hystrixCommandGet(@PathVariable("id") Integer id){

        Department dept = new Department();
        dept.setId(id);
        dept.setDepartmentName("hystrix返回信息：该部门不存在");
        dept.setDbName("no db save");
        return dept;
    }


}

package com.atguigu.feign.controller;

import com.atguigu.common.entity.Department;
import com.atguigu.common.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id){
        return deptClientService.get(id);
    }

    @PostMapping("/dept")
    public boolean save(Department dept){
        return deptClientService.save(dept);
    }

    @GetMapping("/dept")
    public List<Department> list(){
        return deptClientService.list();
    }



}

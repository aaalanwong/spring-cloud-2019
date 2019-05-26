package com.atguigu.common.service;


import com.atguigu.common.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICRO-PROVIDER", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id);

    @PostMapping("/dept")
    public boolean save(Department dept);

    @GetMapping("/dept")
    public List<Department> list();
}

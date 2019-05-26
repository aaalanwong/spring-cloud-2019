package com.atguigu.consumer.controller;

import com.atguigu.common.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    //private String url = "http://localhost:8001";
    private String url = "http://MICRO-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url+"/dept/"+id, Department.class);
    }

    @PostMapping("/dept")
    public boolean save(Department dept){
        return restTemplate.postForObject(url+"/dept", dept, Boolean.class);
    }

    @GetMapping("/dept")
    public List<Department> list(){
        return restTemplate.getForObject(url+"/dept", List.class);
    }
}

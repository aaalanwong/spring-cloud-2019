package com.atguigu.common.service;

import com.atguigu.common.entity.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Department get(Integer id) {
                Department dept = new Department();
                dept.setId(id);
                dept.setDepartmentName("Hystrix-FallbackFactory：服务已停止运行");
                dept.setDbName("no db save");
                return dept;
            }

            @Override
            public boolean save(Department dept) {
                return false;
            }

            @Override
            public List<Department> list() {
                return null;
            }
        };
    }
}

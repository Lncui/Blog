package com.zhlh.blog.service.impl;


import com.zhlh.blog.mapper.BaseMapper;
import com.zhlh.blog.mapper.DepartmentMapper;
import com.zhlh.blog.model.Department;
import com.zhlh.blog.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl extends BaseServiceImpl<Department> implements HelloService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public BaseMapper<Department> getBaseMapper() {
        return departmentMapper;
    }
}

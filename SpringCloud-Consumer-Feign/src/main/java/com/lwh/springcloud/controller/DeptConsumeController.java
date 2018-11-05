package com.lwh.springcloud.controller;


import com.lwh.springcloud.entity.Dept;
import com.lwh.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp 消费者端没有服务层,直接调用服务提供者提供的服务
 */

@RestController
public class DeptConsumeController {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return service.list();
    }
}

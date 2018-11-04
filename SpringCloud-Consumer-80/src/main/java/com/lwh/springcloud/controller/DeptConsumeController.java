package com.lwh.springcloud.controller;

import com.lwh.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp 消费者端没有服务层,直接调用服务提供者提供的服务
 */

@RestController
public class DeptConsumeController {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * RestTemplate提供了多种便捷访问远程HTTP服务的方法,是一种简单便捷的访问restful服务模板类,
     * 是Spring提供的用于访问Rest服务的客户端模板工具集
     * 三个参数
     * url:          Rest请求地址
     * requestMap:   请求参数
     * ResponseBean: HTTP响应被转换成的对象类型
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}

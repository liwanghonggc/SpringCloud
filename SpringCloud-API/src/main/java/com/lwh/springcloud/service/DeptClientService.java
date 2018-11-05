package com.lwh.springcloud.service;

import com.lwh.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author lwh
 * @date 2018-11-05
 * @desp
 */
@FeignClient(value = "springcloud-dept")
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(Dept dept);
}


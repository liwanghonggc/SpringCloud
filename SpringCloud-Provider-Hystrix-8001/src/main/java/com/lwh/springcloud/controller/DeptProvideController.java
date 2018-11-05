package com.lwh.springcloud.controller;

import com.lwh.springcloud.entity.Dept;
import com.lwh.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp
 */
@RestController
public class DeptProvideController {

	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		return service.add(dept);
	}

	/**
	 * 服务熔断示例,一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbackMethod指定的方法
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrixGet")
	public Dept get(@PathVariable("id") Long id){
		Dept dept = service.get(id);
		if(dept == null){
			throw new RuntimeException("该ID： " + id + " 没有对应的信息!");
		}
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list(){
		return service.list();
	}

	public Dept processHystrixGet(@PathVariable("id") Long id){
		return new Dept().setDeptNo(id).setDeptName("该ID： " + id + " 没有对应的信息!").setDbSource("no this data in database");
	}

}

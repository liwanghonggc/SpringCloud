package com.lwh.springcloud.controller;

import com.lwh.springcloud.entity.Dept;
import com.lwh.springcloud.service.DeptService;
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

	/**
	 * 服务发现
	 */
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id){
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list(){
		return service.list();
	}

	/**
	 * 让别人发现我这个服务,不是重点
	 * @return
	 */
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery(){
		//查看Eureka里面的服务
		List<String> services = discoveryClient.getServices();
		System.out.println(services);

		List<ServiceInstance> srvList = discoveryClient.getInstances("springcloud-dept");
		for(ServiceInstance element : srvList){
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
		}

		return this.discoveryClient;
	}

}

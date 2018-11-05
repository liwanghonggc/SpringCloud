package com.lwh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author  lwh
 * @date    2018-11-04
 * @desp    @EnableEurekaClient    本服务启动后会自动注册进eureka服务中
 *          @EnableDiscoveryClient 服务发现
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvider8003 {

	public static void main(String[] args){
		SpringApplication.run(DeptProvider8003.class, args);
	}
}

package com.lwh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author  lwh
 * @date    2018-11-04
 * @desp    @EnableEurekaClient    本服务启动后会自动注册进eureka服务中
 *          @EnableDiscoveryClient 服务发现
 */
@SpringBootApplication
public class DeptProvider8001 {

	public static void main(String[] args){
		SpringApplication.run(DeptProvider8001.class, args);
	}
}

package com.lwh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer80{

	public static void main(String[] args){
		SpringApplication.run(DeptConsumer80.class, args);
	}
}

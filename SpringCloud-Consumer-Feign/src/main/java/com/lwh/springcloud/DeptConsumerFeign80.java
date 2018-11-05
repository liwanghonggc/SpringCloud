package com.lwh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp Feign使用
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lwh.springcloud"})
@ComponentScan("com.lwh.springcloud")
public class DeptConsumerFeign80 {

	public static void main(String[] args){
		SpringApplication.run(DeptConsumerFeign80.class, args);
	}
}

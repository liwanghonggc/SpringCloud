package com.lwh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp @EnableEurekaServer 服务端启动类,接收其他微服务注册进来
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001 {

	public static void main(String[] args){
		SpringApplication.run(EurekaServer7001.class, args);
	}
}

package com.lwh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp Hystrix的DashBoard使用,所有Provider微服务提供类8001,8002,8003都需要监控依赖配置
 *       启动它后,访问http://localhost:9001/hystrix
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerHystrixDashboard9001 {

	public static void main(String[] args){
		SpringApplication.run(DeptConsumerHystrixDashboard9001.class, args);
	}
}

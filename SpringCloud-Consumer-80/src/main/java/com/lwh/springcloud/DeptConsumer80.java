package com.lwh.springcloud;

import com.lwh.loadbalance.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp 在主启动类添加@RibbonClient,在启动微服务的时候就能去加载我们自定义的Ribbon负载均衡算法,name表示针对哪个应用,configuration
 *       表示使用哪个算法
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "springcloud-dept", configuration = MyRule.class)
public class DeptConsumer80{

	public static void main(String[] args){
		SpringApplication.run(DeptConsumer80.class, args);
	}
}

package com.lwh.loadbalance.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwh
 * @date 2018-11-05
 * @desp 我们自定义的负载均衡算法,它不能放在@ComponentScan所扫描的包及其子包下,由于@SpringBootApplication注解自带@ComponentScan,
 *       所以MyRule此处不能放在com.lwh.springcloud包及其子包下,此处我们新建了com.lwh.loadbalance.rule包,否则我们自定义的这个配置类
 *       会被所有的Ribbon客户端所共享,也就是说达不到特殊定制化的目的了
 */

@Configuration
public class MyRule {

    @Bean
    public IRule myRule(){
        return new MyRandomRule();
    }
}

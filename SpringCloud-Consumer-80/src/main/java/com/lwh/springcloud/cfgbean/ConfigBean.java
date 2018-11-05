package com.lwh.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lwh
 * @date 2018-11-04
 * @desp 配置类
 */

@Configuration
public class ConfigBean {

    /**
     * 使用LoadBalanced开启负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 配置使用RandomRule随机负载均衡算法,这里可以不配置,直接使用上面的@LoadBalanced注解使用默认负载均衡算法
     *
     * 根据特定算法从服务列表中选取一个要访问的服务,Ribbon提供的算法
     * a) RoundRobinRule,轮询
     * b) RandomRule,随机
     * c) AvailabilityFilteringRule,会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,还有并发连接数量超过阈值的服务,然后对剩余的服务列表按照轮询策略进行访问
     * d) WeightedResponseTimeRule,根据平均响应时间计算所有的服务权重,响应时间越快服务权重越大,被选中的概率越高,初始启动时选择RoundRobin
     * e) RetryRule,先按照RoundRobin的策略获取服务,如果获取服务失败则在指定的时间内重试,获取可用的服务
     * f) BestAvailableRule,会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务
     * g) ZoneAvoidanceRule,默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

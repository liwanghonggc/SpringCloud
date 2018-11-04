1.什么是微服务
  微服务是一种架构模式(风格),它提倡将单一应用划分成一组小的服务(根据业务拆分、根据技术拆分等),每个服务运行在其独立的进程中,服务之间相互协调、互相配合,为用户提供最终价值.
  服务之间采用轻量级的通信机制互相沟通(通常是基于HTTP的Restful API)(Dubbo是基于RPC的,而Spring Cloud基于HTTP)

2.微服务与微服务架构
  微服务强调的是服务的大小,它关注的是某一个点,是具体解决某一个问题的一个服务应用
  微服务架构是一种架构模式,宏观,强调以什么样的方式将一个个微服务组装起来形成一个整体对外提供服务

3.微服务优点
  1) 每个服务足够内聚,足够小,代码容易理解,这样能够聚焦于一个指定的业务功能或者需求
  2) 开发简单,开发效率高,一个服务专一的只干一件事
  3) 松耦合的
  4) 能使用不同的语言开发
  5) 微服务只是业务逻辑的代码,不会和HTML、CSS或其他界面的组件混合
  6) 每个微服务都有自己的存储能力,可以有自己的数据库,也可以有统一数据库

  缺点
  1) 分布式系统的复杂性
  2) 多服务运维难,系统部署依赖,服务间通信成本,数据一致性

4.微服务技术栈

  微服务条目                                落地技术

  服务开发                                  SpringBoot、Spring、SpringMVC
  服务配置与管理                             Netflix公司的Archaius、阿里的Diamond等
  服务注册与发现                             Eureka、Consul、Zookeeper
  服务调用                                  Rest、RPC、gRPC
  服务熔断器                                Hystrix、Envoy
  负载均衡                                  Ribbon、Nginx
  服务接口调用                              Feign
  消息队列                                  kafka、RabbitMQ、ActiveMQ
  服务配置中心管理                           SpringCloudConfig、Chef等
  服务路由(API网关)                          Zuul
  服务监控                                  Zabbix、Nagios、Metrics、Spectator
  服务部署                                  Docker、OpenStack、Kubernetes

5、SpringCloud和SpringBoot是什么关系
   SpringBoot专注于快速方便的开发单个个体微服务,而SpringCloud是关注全局微服务协调整理治理框架,它将SpringBoot开发的一个个单体微服务整合并管理起来

6、SpringBoot与Dubbo

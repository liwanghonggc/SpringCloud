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

7、Eureka
   Netflix在设计Eureka时遵守的就是AP原则.

   1) Eureka是什么
       它是Netflix的一个子模块,也是核心模块之一,Eureka是一个基于Rest的服务,用于定位服务,以实现云端中间层服务发现和故障转移.服务注册与发现对于微服务架构
   来说是非常重要的,有了服务注册与发现,只需要使用服务的标识符,就可以访问到服务,而不需要修改服务调用的配置文件了.功能类似于Dubbo的注册中心,比如Zookeeper.

   2) Eureka的基本架构
      SpringCloud封装了Netflix公司开发的Eureka模块来实现服务注册和发现.Eureka采用了C-S的设计架构,Eureka Server作为服务注册功能的服务器,它是服务注册
   中心.而系统中的其他微服务,使用Eureka的客户端连接到Eureka Server并维持心跳连接,这样系统的维护人员就可以通过Eureka Server来监控系统中各个微服务是否正
   常运行.SpringCloud的一些其他模块(如Zuul)就可以通过Eureka Server来发现系统中的其他微服务,并执行相关的逻辑.

      Eureka包含两个组件:Eureka Server和Eureka Client,各个节点启动以后,会在Eureka Server中进行注册,这样Eureka Server的服务注册表中将会存储所有的可
   用服务节点的信息,服务节点的信息可用在界面中直观看到.
      Eureka Client是一个Java客户端,用于简化和Eureka Server的交互,客户端同时也具备一个内置的、使用轮询(round-robin)负载均衡的负载均衡器.在应用启动后,
   将会向Eureka Server发送心跳(默认周期为30秒),如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳,Eureka将会从服务注册表中把这个服务节点移除(默认90秒)

   3) Eureka的自我保护机制
      某时刻某微服务不可用了,Eureka不会立刻清理,依旧会对该微服务的信息进行保存.

      默认情况下,如果Eureka Server在一定时间内没有接收到某个微服务实例的心跳,Eureka Server将会注销该实例(默认90秒),但是当网络分区故障发生时,微服务与Eureka Server
   之间无法正常通信,因为微服务本身其实是健康的,此时不应该注销这个微服务,Eureka通过自我保护模式来解决这个问题.当Eureka Server在短时间内丢失过多的客户端时,那么这个节点
   就会进入自我保护模式,一旦进入这个模式,Eureka Server就会保护服务注册表中的信息,不再删除服务注册表中的数据(也就是不注销任何微服务).当网络故障恢复后,该Eureka Server
   节点会自动退出自我保护模式.

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

      可以使用Eureka.server.enable-self-preservation = false 禁用自我保护模式,不推荐

   4) CAP理论:一个分布式系统不可能同时很好的满足一致性,可用性和分区容错性这三个需求,最多只能同时较好的满足两个

      传统的关系型数据库是ACID,NoSQL数据库是CAP

      什么是CAP?
      C:Consistency,强一致性
      A:Availability,可用性
      P:Partition tolerance,分区容错性

      属于CP的:Redis、HBase、MongoDB

      CA:单点集群,满足一致性、可用性的系统,通常在可扩展性上不太强大
      CP：满足一致性,分区容忍性的系统,通常性能不高
      AP:满足可用性,分区容忍性的系统,通常可能对一致性要求低一些

      由于当前的网络硬件肯定会出现延迟丢包等问题,所以分区容忍性是我们必须要实现的.所以我们只能在一致性和可用性之间进行权衡,没有NoSQL系统能同时保证这三点


   5) Eureka和Zookeeper区别

          Eureka遵守AP,Zookeeper遵守CP

          Zookeeper保证CP,当向注册中心查询服务列表时,我们可以容忍注册中心返回的是几分钟以前的注册信息,但不能接受服务直接down掉不可用,也就是说,服务注册功能对可用性的要求要高于
      一致性.但是,ZK会出现这样一种情况,当master节点因为网络故障与其他节点失去联系时,剩余节点会重新进行leader选举,问题在于,选举leader时间太长,30s~120s,且选举期间整个ZK集群都
      是不可用的,这就导致在选举期间注册服务瘫痪,在云部署环境下,因网络问题使得ZK集群失去master节点是较大概率会发生的事,虽然服务最终能够恢复,但是漫长的选举时间导致注册长期不可用
      是不能容忍的.

          Eureka保证AP,Eureka看明白了这一点,因此在设计时就优先保证可用性.Eureka各个节点是平等的,几个节点挂掉不会影响正常节点的工作,剩余节点依然可以提供注册和查询服务.在Eureka
      的客户端向某个Eureka注册时如果发现连接失败,则会自动切换至其他节点,只要有一台Eureka在,就能保证注册服务可用(保证可用性),只不过查到的注册信息可能不是最新的(不保证强一致性),
      除此之外,Eureka还有一种自我保护机制,如果在15分钟内超过85%的节点都没有正常的心跳,那么Eureka就任务客户端与注册中心出现了网络故障,此时会出现以下几种情况:
      a) Eureka不再从注册列表中移除因为长时间没有收到心跳而应该过期的服务
      b) Eureka仍然能够接受新服务注册和查询请求,但是不会被同步到其他节点上(即保证当前节点仍然可用)
      c) 当网络稳定时,当前实例新的注册信息会被同步到其他节点中

          因此,Eureka可以很好的应对因网络故障导致部分节点失去联系的情况,而不会向Zookeeper那样使得整个注册服务瘫痪.

8、Ribbon负载均衡
       Spring Cloud Ribbon是基于Netflix Ribbon实现的额一套客户端负载均衡的工具.

       简单的说,Ribbon是Netflix发布的开源项目,主要功能是提供客户端的软件负载均衡算法,将Netflix的中间服务层连接在一起,Ribbon客户端组件提供一系列完善的配置项如连接超时、重试等.简单
   的说,就是在配置文件中列出Load Balancer(简称LB)后面所有的机器,Ribbon会自动帮你基于某种规则(如简单轮询、随机连接等)去连接这些机器,我们也很容易使用Ribbon实现自定义的负载均衡算法.

       Ribbon工作时分成两步
   第一步先选择Eureka Server,它优先选择在同一个区域内负载较少的Server.
   第二步再根据用户指定策略,在从server取到的服务注册列表中选择一个地址.

   1) 负载均衡
      集中式LB:即在服务的消费方和提供方之间使用独立的LB设施(可以是硬件F5、也可以是软件,如Nginx),由该设施负责把访问请求通过某种策略转发至服务的提供方.
      进程内LB:将LB逻辑集成到消费方,消费方从服务注册中心获知有哪些地址可用,然后再从这些地址中选择出一个合适的服务器.Ribbon就属于进程内LB,它只是一个类库,集成于消费方进程,消费方通过它
              来获取服务提供方的地址.

   2) Ribbon核心组件IRule
      根据特定算法从服务列表中选取一个要访问的服务,Ribbon提供的算法
      a) RoundRobinRule,轮询
      b) RandomRule,随机
      c) AvailabilityFilteringRule,会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,还有并发连接数量超过阈值的服务,然后对剩余的服务列表按照轮询策略进行访问
      d) WeightedResponseTimeRule,根据平均响应时间计算所有的服务权重,响应时间越快服务权重越大,被选中的概率越高,初始启动时选择RoundRobin
      e) RetryRule,先按照RoundRobin的策略获取服务,如果获取服务失败则在指定的时间内重试,获取可用的服务
      f) BestAvailableRule,会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务
      g) ZoneAvoidanceRule,默认规则,复合判断server所在区域的性能和server的可用性选择服务器

9、Feign负载均衡

   1) Feign是怎么出来的?
      有了Ribbon,我们可以直接调用我们的微服务进行访问,如private static final String REST_URL_PREFIX = "http://springcloud-dept".但是,大家目前都习惯了面向
   接口编程,比如WebService接口,比如我们的Dao接口,这个已经是大家的规范.Feign支持通过接口注解+注解,调用我们的服务.



































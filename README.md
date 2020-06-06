SpringCloud Hoxton+SpringCloud alibaba新版本教程

由于很多spring cloud的技术栈都在新的一年中停止的更新所以必然有新的技术代替，因此我们必须要学习新的技术。这里不会对一些基本的基础知识进行详细的介绍。主要针对映有编程基础的人员。
- 2018年7月，人家官方就突然宣布Eureka 2.x停止开源计划了.Eureka停用,可以使用zk作为服务注册中心
- 服务调用,Ribbon准备停更,代替为LoadBalance
- Feign改为OpenFeign
- Hystrix是比较稳定的，并且Hystrix只是停止开发新的版本，并不是完全停止维护，Bug什么的依然会维护的。因此短期内，Hystrix依然是继续使用的。
- Zuul改为gateway
- 服务配置Config改为  Nacos
- 服务总线Bus改为Nacos



代码内容更具下图顺序更新:

![](https://www.520java.cn/81b651f7fcbb7ab9c97895b20f93db6c_jinBlog_20200518_cloudupdate-01.png)

跟随视频敲的cloud2020代码：https://github.com/i520java-jinge/springcloud2020
spring-config配置中心 https://github.com/i520java-jinge/springcloud-config
我自己编写的文档教程，并且衍生补充很多内容，更佳细致化、且有截图图演示
代码更新进度
- [前期准备]-01  
    文档教程: https://www.520java.com/f/article/17.html
- [eureka集群]-02  
    文档教程: https://www.520java.com/f/article/18.html
- [eureka集群]-03  
    文档教程: https://www.520java.com/f/article/19.html
- [zookeeper集群]-04 
    文档教程: https://www.520java.com/f/article/20.html
- [consul]-05
    文档教程: https://www.520java.com/f/article/21.html
- [ribbon]-06
    文档教程: https://www.520java.com/f/article/22.html
- [OpenFeign]-07
    文档教程: https://www.520java.com/f/article/23.html
- [Hystrix]-08    
    文档教程: https://www.520java.com/f/article/24.html
- [gateway网关]-09 
    文档教程: https://www.520java.com/f/article/25.html
- [config配置中心]-10
    文档教程: https://www.520java.com/f/article/26.html
- [Bus消息总线]-11
    文档教程: https://www.520java.com/f/article/27.html
- [stream消息驱动]-12
    文档教程: https://www.520java.com/f/article/28.html    
- [sleuth-zipkin链路]-13
    文档教程: https://www.520java.com/f/article/29.html
代码持续更新中....

## 具体教程请参考 https://www.520java.com
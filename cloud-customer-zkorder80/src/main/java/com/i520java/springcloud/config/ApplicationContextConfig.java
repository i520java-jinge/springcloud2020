package com.i520java.springcloud.config;/**
 * date: 2020/5/18 09:34<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @PackageName:com.i520java.springcloud.config
 * @ClassName:ApplicationContextConfig
 * @author:金格[JIN_GE]
 * @date:2020/5/18 09:34 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Configuration
public class ApplicationContextConfig {

     /**
      * spring官方提供的 远程调用组件
      * @Author 金格[JIN_GE]
      * @Date 09:35 2020/5/18
      * @Param
      * @return
      * @description 此模板由【Jin ge】提供!
      *              更多教程请访问 https://www.520java.com 交流学习
      **/
     @Bean
     @LoadBalanced  //默认的负载均衡
     public RestTemplate  getRestTemplate(){
         return   new RestTemplate();
     }

}

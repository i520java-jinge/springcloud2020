package com.i520java.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName:com.i520java.alibaba.config
 * @ClassName:AppConfig
 * @author:金格[JIN_GE]
 * @date:2020/6/4 18:53
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Configuration
public class AppConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}

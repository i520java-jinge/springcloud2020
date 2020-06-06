package com.i520java.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName:com.i520java.sentinel
 * @ClassName:SentinelServer8401
 * @author:金格[JIN_GE]
 * @date:2020/6/6 15:46
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelServer8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServer8401.class);
    }
}

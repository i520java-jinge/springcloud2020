package com.i520java.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @PackageName:com.i520java.springcloud
 * @ClassName:HystrixDashboardMain9001
 * @author:金格[JIN_GE]
 * @date:2020/6/1 17:04
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {


    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class);
    }
}

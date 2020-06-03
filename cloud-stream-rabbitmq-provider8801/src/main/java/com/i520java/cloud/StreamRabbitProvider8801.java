package com.i520java.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PackageName:com.i520java.cloud
 * @ClassName:StreamRabbitProvider8801
 * @author:金格[JIN_GE]
 * @date:2020/6/3 17:20
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitProvider8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitProvider8801.class);
    }
}

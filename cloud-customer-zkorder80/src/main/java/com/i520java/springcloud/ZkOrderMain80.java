package com.i520java.springcloud;/**
 * date: 2020/4/29 21:39<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @PackageName:com.i520java.springcloud
 * @ClassName:OrderMain80
 * @author:金格[JIN_GE]
 * @date:2020/4/29 21:39 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain80.class);
    }
}


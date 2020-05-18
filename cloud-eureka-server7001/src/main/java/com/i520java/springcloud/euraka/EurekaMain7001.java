package com.i520java.springcloud.euraka;/**
 * date: 2020/5/18 15:30<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @PackageName:com.i520java.springcloud.euraka
 * @ClassName:EurekaMain7001
 * @author:金格[JIN_GE]
 * @date:2020/5/18 15:30 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {

        SpringApplication.run(EurekaMain7001.class);
    }
}

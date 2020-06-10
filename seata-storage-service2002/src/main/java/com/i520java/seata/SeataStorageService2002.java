package com.i520java.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName:com.i520java.seata
 * @ClassName:SeataOrderService2001
 * @author:金格[JIN_GE]
 * @date:2020/6/8 15:36
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //取消数据源的自动创建。使用我们自己配置的seata代理的数据源
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.i520java.seata.dao")
public class SeataStorageService2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002.class);
    }
}

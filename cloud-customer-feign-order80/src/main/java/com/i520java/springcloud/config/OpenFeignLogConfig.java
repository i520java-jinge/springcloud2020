package com.i520java.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @PackageName:com.i520java.springcloud.config
 * @ClassName:OpenFeignLogConfig
 * @author:金格[JIN_GE]
 * @date:2020/5/31 11:37 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Configuration
public class OpenFeignLogConfig {


    //定义日志级别bean
    @Bean
    Logger.Level feignLoggerLeave(){
        return Logger.Level.FULL;
    }


}

package com.i520java.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.i520java.cloud.controller
 * @ClassName:ConfigController
 * @author:金格[JIN_GE]
 * @date:2020/6/2 21:53
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public   String getConfigInfo(){
        return  configInfo;
    }
}

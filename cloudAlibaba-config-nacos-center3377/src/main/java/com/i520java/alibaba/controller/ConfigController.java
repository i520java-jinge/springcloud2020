package com.i520java.alibaba.controller;

import com.i520java.springcloud.comments.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.i520java.alibaba.controller
 * @ClassName:ConfigController
 * @author:金格[JIN_GE]
 * @date:2020/6/4 21:07
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@RefreshScope //动态刷新
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/config/info")
    public CommentResult  getConfigInfo(){
        if(configInfo!=null&&!"".equals(configInfo))
        return   new CommentResult(200,"可以获得外部配置数据",configInfo);

        return  new CommentResult(500,"获得外部配置数据失败！");
    }
}

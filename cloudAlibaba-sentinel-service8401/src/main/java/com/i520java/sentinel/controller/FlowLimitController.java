package com.i520java.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.i520java.sentinel.controller.flowlimithander.MyHandler;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.i520java.sentinel.controller
 * @ClassName:FlowLimitController
 * @author:金格[JIN_GE]
 * @date:2020/6/7 23:20
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
public class FlowLimitController {


    //blockHandlerClass 指定限流兜底处理类  blockHandler 指定类中的方法名
    @GetMapping("/testMyHandler")
    @SentinelResource(value = "testMyHandler",blockHandlerClass = MyHandler.class,blockHandler = "globalHandler")
    public CommentResult   testMyHandler(){
        return   new CommentResult(200,"正常响应结果!");
    }


}

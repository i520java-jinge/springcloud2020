package com.i520java.alibaba.controller;

import com.i520java.springcloud.comments.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.i520java.alibaba.controller
 * @ClassName:PaymentController
 * @author:金格[JIN_GE]
 * @date:2020/6/4 18:01
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
public class PaymentController {


    @Value("${server.port}")
    private  String serverPort;


    @GetMapping("/payment/nacos/{id}")
    public CommentResult  getPayment(@PathVariable("id") Integer  id){
        return   new CommentResult(200,"这是nacos测试结果:当前的端口是:"+serverPort);
    }

}

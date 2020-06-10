package com.i520java.alibaba.controller;

import com.i520java.springcloud.comments.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    //模拟数据数据
    public static Map<Integer,String>  mysqlData=new HashMap<>();
    static {
        mysqlData.put(1,"id:"+ UUID.randomUUID() +",name:张三");
        mysqlData.put(2,"id:"+ UUID.randomUUID() +",name:李四");
        mysqlData.put(3,"id:"+ UUID.randomUUID() +",name:王五");
    }

    @Value("${server.port}")
    private  String serverPort;


    @GetMapping("/payment/nacos/{id}")
    public CommentResult  getPayment(@PathVariable("id") Integer  id){
        if(mysqlData.containsKey(id))
            return   new CommentResult(200,"查询成功！端口:"+serverPort,mysqlData.get(id));
        else
            return   new CommentResult(200,"id:【"+id+"】的数据不存在！，端口:"+serverPort);
    }

}

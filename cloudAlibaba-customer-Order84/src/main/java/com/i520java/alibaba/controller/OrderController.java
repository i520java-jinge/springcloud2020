package com.i520java.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.i520java.alibaba.service.FeignPaymentService;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PackageName:com.i520java.alibaba.controller
 * @ClassName:OrderController
 * @author:金格[JIN_GE]
 * @date:2020/6/4 18:41
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate  restTemplate;

    @Value("${miscserver-urls.nacos-provider-payment}")
    private  String  providerPaymentUrl;


    @GetMapping("/customer/payment/nacos/{id}")
    //sentinel 熔断处理
    @SentinelResource(value = "fallback",fallback = "getPaymentFallback" ,
            blockHandler = "getPaymentBlockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommentResult getPayment(@PathVariable("id") Integer  id){
        //刻意给出异常 演示熔断
        if(id==4){
               throw   new IllegalArgumentException("参数："+id+" 属于非法参数！");
        }else if(id>5){
            throw   new NullPointerException("非法的操作");
        }
        CommentResult rs=restTemplate.getForObject(providerPaymentUrl+"/payment/nacos/"+id,CommentResult.class);
        return  rs;
    }
    //熔断处理
    public CommentResult getPaymentFallback(@PathVariable("id") Integer  id,Throwable e){
        return   new CommentResult(500,"sentinel熔断处理，",e.getMessage());
    }

    //限流处理
    public CommentResult  getPaymentBlockHandler(@PathVariable("id") Integer  id, BlockException e){
        return   new CommentResult(500,"sentinel 限流处理，",e.getMessage());
    }


    //注入feign 业务
    @Resource
    private FeignPaymentService  feignPaymentService;

    @GetMapping("/customer/openfeign/payment/nacos/{id}")
    public CommentResult getFeignPayment(@PathVariable("id") Integer  id){
        return   feignPaymentService.getPayment(id);
    }

}

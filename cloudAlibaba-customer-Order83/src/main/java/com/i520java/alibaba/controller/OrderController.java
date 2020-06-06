package com.i520java.alibaba.controller;

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

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate  restTemplate;

    @Value("${miscserver-urls.nacos-provider-payment}")
    private  String  providerPaymentUrl;



    @GetMapping("/customer/payment/nacos/{id}")
    public CommentResult getPayment(@PathVariable("id") Integer  id){

        CommentResult rs=restTemplate.getForObject(providerPaymentUrl+"/payment/nacos/"+id,CommentResult.class);
        return  rs;
    }


}

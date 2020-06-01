package com.i520java.springcloud.controller;/**
 * date: 2020/5/18 10:01<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @PackageName:com.i520java.springcloud.controller
 * @ClassName:OrderController
 * @author:金格[JIN_GE]
 * @date:2020/5/18 10:01 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class OrderController {

    //单机模式可用
    //private  static  final String PAYMENT_URL="http://localhost:8001";
    //集群模式
    private  static  final String PAYMENT_URL="http://cloud-payment-service";

    @Autowired
    RestTemplate  restTemplate;

    @GetMapping("/payment/create")
    public CommentResult<Payment>  create(Payment payment){
       return   restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommentResult.class);
    }


    @GetMapping("/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Integer id) {
        return   restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }


}

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
import com.i520java.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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


    @Resource
    private PaymentFeignService  paymentFeignService;



    @GetMapping("/payment/create")
    public CommentResult<Payment>  create(Payment payment){
       return   paymentFeignService.create(payment);
    }


    @GetMapping("/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Integer id) {
        return   paymentFeignService.getPayment(id);
    }

    @GetMapping("/timeout/ex")
    public  String  timeoutEx(){
       return paymentFeignService.timeoutEx();
    }

}

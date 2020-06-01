package com.i520java.springcloud.controller;/**
 * date: 2020/5/18 10:01<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import com.i520java.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "hystrix_global_Handler")
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



    /**
     * 成功响应
     * @Author 金格[JIN_GE]
     * @Date 16:49 2020/5/31
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/hystrix/success/{id}")
    public CommentResult getByIdForHystrixSuccess(@PathVariable("id") Integer id){
        CommentResult commentResult=paymentFeignService.getByIdForHystrixSuccess(id);
        String  tname=Thread.currentThread().getName();
        String info="************===>【客户端80controller--远程调用--HystrixSuccess方法】查询数据成功,客户端线程是【"+tname+"】,id:【"+id+"】，远程返回数据是："+ JSONUtil.toJsonStr(commentResult);
        log.info(info);
        return  commentResult;
    }


    /**
     * 模拟延时超时响应
     * @Author 金格[JIN_GE]
     * @Date 16:50 2020/5/31
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "getByIdForHystrixTimeOutHandler",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public CommentResult getByIdForHystrixTimeOut(@PathVariable("id") Integer id){
        CommentResult commentResult=paymentFeignService.getByIdForHystrixTimeOut(id);
        String  tname=Thread.currentThread().getName();
        String info="************===>【客户端80controller--远程调用--ForHystrixTimeOut方法】查询数据成功,客户端线程是【"+tname+"】,id:【"+id+"】，远程返回数据是："+ JSONUtil.toJsonStr(commentResult);
        log.info(info);
        return  commentResult;
    }


    public CommentResult getByIdForHystrixTimeOutHandler(@PathVariable("id") Integer id){
        String tname=Thread.currentThread().getName();
        String info="************ Error【客户端80controller--远程调用--ForHystrixTimeOut方法】查询数据失败,线程是【"+tname+"】,id:【"+id+"】";
        return new CommentResult(500,info);
    }

    //默认的ForBack
    public CommentResult hystrix_global_Handler(){
        String info="************ Error【客户端80controller】,调用错误！";
        return new CommentResult(500,info);
    }

}

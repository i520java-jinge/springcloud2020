package com.i520java.springcloud.service;

import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * date: 2020/5/30 14:54<br/>
 *
 * @author jinge<br />
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */
@Component
@RequestMapping("/payment")
@FeignClient("CLOUD-PAYMENT-SERVICE") //CLOUD-PAYMENT-SERVICE 是支付模块的服务名称
public interface PaymentFeignService {


    /**
     * 增加
     * @Author 金格[JIN_GE]
     * @Date 20:28 2020/4/29
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @PostMapping("/create")
    public CommentResult  create(@RequestBody Payment payment);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommentResult getPayment(@PathVariable("id") Integer id);


    /**
     *服务发现
     * @Author 金格[JIN_GE]
     * @Date 13:43 2020/5/21
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/discovery")
    public DiscoveryClient getDiscoveryClient();

    /**
     * 演示超时方法
     * @Author 金格[JIN_GE]
     * @Date 16:59 2020/5/30
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/timeout/ex")
    public  String  timeoutEx();

}

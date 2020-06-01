package com.i520java.springcloud.service;

import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.i520java.springcloud.service
 * @ClassName:PaymentFeignForBackService
 * @author:金格[JIN_GE]
 * @date:2020/6/1 14:15
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component("paymentFeignForBackService")
public class PaymentFeignForBackService implements PaymentFeignService {


    @Override
    public CommentResult create(Payment payment) {
        return null;
    }

    @Override
    public CommentResult getPayment(Integer id) {
        return null;
    }

    @Override
    public DiscoveryClient getDiscoveryClient() {
        return null;
    }

    @Override
    public String timeoutEx() {
        return null;
    }

    //这里我给一个方法6添加代码作为演示，其他的也是一样
    @Override
    public CommentResult getByIdForHystrixSuccess(Integer id) {
        return new CommentResult(500,"######################===》getByIdForHystrixSuccess---->远程调用失败！");
    }

    @Override
    public CommentResult getByIdForHystrixTimeOut(Integer id) {
        return null;
    }
}

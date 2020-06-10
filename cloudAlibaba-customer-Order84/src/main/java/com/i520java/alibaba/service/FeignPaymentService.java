package com.i520java.alibaba.service;

import com.i520java.alibaba.service.imp.FeignPaymentServiceFallBack;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @PackageName:com.i520java.alibaba.service
 * @ClassName:FeignPaymentService
 * @author:金格[JIN_GE]
 * @date:2020/6/8 01:10
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@FeignClient(value = "nacos-provider-payment",fallback = FeignPaymentServiceFallBack.class)
public interface FeignPaymentService {



    @GetMapping("/payment/nacos/{id}")
    public CommentResult getPayment(@PathVariable("id") Integer  id);

}

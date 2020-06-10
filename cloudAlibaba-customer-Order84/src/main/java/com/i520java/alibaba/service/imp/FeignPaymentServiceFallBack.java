package com.i520java.alibaba.service.imp;

import com.i520java.alibaba.service.FeignPaymentService;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.i520java.alibaba.service.imp
 * @ClassName:FeignPaymentServiceFallBack
 * @author:金格[JIN_GE]
 * @date:2020/6/8 01:12
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component
public class FeignPaymentServiceFallBack  implements FeignPaymentService {

    @Override
    public CommentResult getPayment(Integer id) {
        return new CommentResult(500,"fegin 服务降级,form FeignPaymentServiceFallBack！");
    }
}

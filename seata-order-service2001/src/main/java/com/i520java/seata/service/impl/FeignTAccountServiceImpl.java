package com.i520java.seata.service.impl;

import com.i520java.seata.aop.WorkAspect;
import com.i520java.seata.service.FeignTAccountService;
import com.i520java.springcloud.comments.CommentResult;
import feign.hystrix.FallbackFactory;
import io.seata.core.exception.TransactionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @PackageName:com.i520java.seata.service.impl
 * @ClassName:FeignTAccountServiceImpl
 * @author:金格[JIN_GE]
 * @date:2020/6/9 13:35
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component
public class FeignTAccountServiceImpl  implements FeignTAccountService {

    @Override
    public CommentResult decrease(Long userId, Double money) {
        return new CommentResult(543,"------>扣款服务降级");
    }

    @Override
    public CommentResult getAccount(Long id) {
        return new CommentResult(543,"------>查询账户服务降级");
    }


}

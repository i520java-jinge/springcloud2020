package com.i520java.seata.service.impl;

import com.i520java.seata.aop.WorkAspect;
import com.i520java.seata.service.FeignTStorageService;
import com.i520java.springcloud.comments.CommentResult;
import io.seata.core.exception.TransactionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @PackageName:com.i520java.seata.service.impl
 * @ClassName:FeignTStorageServiceImpl
 * @author:金格[JIN_GE]
 * @date:2020/6/9 13:32
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component  //服务降级
public class FeignTStorageServiceImpl implements FeignTStorageService {

    @Override
    public CommentResult decrease(Long productId, Integer count) {
        return new CommentResult(543,"--------->减库存服务降级...");
    }

    @Override
    public CommentResult getStorage(Long id) {
        return new CommentResult(543,"--------->查询库存服务降级...");
    }
}

package com.i520java.seata.service;

import com.i520java.seata.service.impl.FeignTAccountServiceImpl;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName:com.i520java.seata.service
 * @ClassName:FeignTStorageService
 * @author:金格[JIN_GE]
 * @date:2020/6/8 16:57
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component
@FeignClient(value = "seata-account-service",fallback = FeignTAccountServiceImpl.class)
public interface FeignTAccountService {


    //远程减库存
    @PostMapping(value = "/account/decrease")
    public CommentResult  decrease(@RequestParam("userId") Long userId, @RequestParam("money") Double money);


    //主键查询账户
    @GetMapping("/account/get/{id}")
    public CommentResult getAccount(@PathVariable("id") Long id);
}

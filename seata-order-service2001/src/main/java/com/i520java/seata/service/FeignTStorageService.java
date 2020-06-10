package com.i520java.seata.service;

import com.i520java.seata.service.impl.FeignTStorageServiceImpl;
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
@FeignClient(value = "seata-storage-service",fallback = FeignTStorageServiceImpl.class)
public interface FeignTStorageService {


    //远程库存
    @PostMapping(value = "/storage/decrease")
    public CommentResult  decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count);


    //远程主键查询库存
    @GetMapping("/storage/get/{id}")
    public CommentResult getStorage(@PathVariable("id") Long id);

}

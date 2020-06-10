package com.i520java.seata.controller;

import com.i520java.seata.entity.TStorage;
import com.i520java.seata.service.TStorageService;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.util.I520JavaPage;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * (TStorage)表控制层
 *
 * @author makejava
 * @since 2020-06-08 20:27:02
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@Slf4j
public class TStorageController {

    //业务层
    @Resource
    private TStorageService tStorageService;



    //远程减库存
    //远程库存
    @PostMapping(value = "/storage/decrease")
    public CommentResult  decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count){

        return tStorageService.decrease(productId,count);
    }

    //主键查询库存
    @GetMapping("/storage/get/{id}")
    public CommentResult getStorage(@PathVariable("id") Long id){
            return   tStorageService.getStorage(id);
    }


}
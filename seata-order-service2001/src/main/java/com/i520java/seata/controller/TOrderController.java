package com.i520java.seata.controller;

import com.i520java.seata.entity.TOrder;
import com.i520java.seata.service.FeignTAccountService;
import com.i520java.seata.service.FeignTStorageService;
import com.i520java.seata.service.TOrderService;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.util.I520JavaPage;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-06-08 16:36:51
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@Slf4j
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    @Resource
    private FeignTStorageService feignTStorageService;

    @Resource
    private FeignTAccountService feignTAccountService;

    //下单
    @GetMapping("/order/create")
    public CommentResult create(TOrder  tOrder) {
        return this.tOrderService.insert(tOrder);
    }



    //远程主键查询库存
    @GetMapping("/order/storage/get/{id}")
    public CommentResult getStorage(@PathVariable("id") Long id){
     return  feignTStorageService.getStorage(id);
    }

    //主键查询账户
    @GetMapping("/order/account/get/{id}")
    public CommentResult getAccount(@PathVariable("id") Long id){
        return  feignTAccountService.getAccount(id);
    }


}
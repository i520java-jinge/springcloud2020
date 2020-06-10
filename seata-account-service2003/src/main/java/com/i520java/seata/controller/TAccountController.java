package com.i520java.seata.controller;

import com.i520java.seata.entity.TAccount;
import com.i520java.seata.service.TAccountService;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.util.I520JavaPage;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * (TAccount)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:04
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@Slf4j
public class TAccountController {
    /**
     * 服务对象
     */
    @Resource
    private TAccountService tAccountService;


    //远程减库存
    @PostMapping(value = "/account/decrease")
    public CommentResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Double money){
        return  tAccountService.decrease(userId,money);
    }


    //主键查询账户
    @GetMapping("/account/get/{id}")
    public CommentResult getAccount(@PathVariable("id") Long id){
        return   tAccountService.getAccount(id);
    }


}
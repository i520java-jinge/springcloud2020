package com.i520java.seata.service;

import com.i520java.seata.entity.TAccount;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * (TAccount)表业务服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:12:03
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public interface TAccountService {


    //减余额
    public CommentResult decrease( Long userId,Double money);

    //主键查询账户
    public CommentResult getAccount( Long id);
}
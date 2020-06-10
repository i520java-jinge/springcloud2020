package com.i520java.seata.service;

import com.i520java.seata.entity.TStorage;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * (TStorage)表业务服务接口
 *
 * @author makejava
 * @since 2020-06-08 20:26:59
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public interface TStorageService {

    //减库存
    public CommentResult decrease(Long productId, Integer count);



    //查询库存
    public CommentResult getStorage(Long  id);

}
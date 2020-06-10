package com.i520java.seata.service;

import com.i520java.seata.entity.TOrder;
import com.i520java.springcloud.comments.CommentResult;

import java.util.List;
import java.util.Map;


/**
 * (TOrder)表业务服务接口
 *
 * @author makejava
 * @since 2020-06-08 16:36:50
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public interface TOrderService {


    
    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    CommentResult insert(TOrder tOrder);



}
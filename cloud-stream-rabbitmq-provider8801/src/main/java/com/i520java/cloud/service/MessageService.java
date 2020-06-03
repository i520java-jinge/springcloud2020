package com.i520java.cloud.service;

import com.i520java.springcloud.comments.CommentResult;

/**
 * @PackageName:com.i520java.cloud.service
 * @ClassName:MessageService
 * @author:金格[JIN_GE]
 * @date:2020/6/3 20:12
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
public interface MessageService {

    public CommentResult send(String message);
}

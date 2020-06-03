package com.i520java.cloud.service.impl;

import com.i520java.cloud.service.MessageService;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @PackageName:com.i520java.cloud.service.impl
 * @ClassName:MessageServiceImpl
 * @author:金格[JIN_GE]
 * @date:2020/6/3 20:13
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageChannel  output;

    @Override
    public CommentResult send(String message) {
        CommentResult  rs=new CommentResult(200,"发送信息成功!","信息内容:【"+message+"】");
        boolean send = output.send(MessageBuilder.withPayload(message).build());
        if(!send) new CommentResult(500,"发送信息失败!","信息内容:【"+message+"】");
        return rs;
    }
}

package com.i520java.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.i520java.cloud.controller
 * @ClassName:MessagesController
 * @author:金格[JIN_GE]
 * @date:2020/6/3 20:54
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class MessagesController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void  input(Message<String> message){
            log.info("------------->当前端口:【"+serverPort+"】，收到信息：【"+message.getPayload()+"】");
    }

}

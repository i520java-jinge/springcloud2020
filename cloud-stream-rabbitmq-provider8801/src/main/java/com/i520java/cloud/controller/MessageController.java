package com.i520java.cloud.controller;

import com.i520java.cloud.service.MessageService;
import com.i520java.springcloud.comments.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PackageName:com.i520java.cloud.controller
 * @ClassName:MessageController
 * @author:金格[JIN_GE]
 * @date:2020/6/3 20:24
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
public class MessageController {

    @Resource
    MessageService  messageService;

    @GetMapping("/sendmsg")
    public CommentResult  sendMsg(String msg){
        return  messageService.send(msg);
    }
}

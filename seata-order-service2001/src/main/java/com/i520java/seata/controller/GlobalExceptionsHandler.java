package com.i520java.seata.controller;

import com.i520java.springcloud.comments.CommentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * @PackageName:com.i520java.seata.config
 * @ClassName:GlobalExceptionsHandler
 * @author:金格[JIN_GE]
 * @date:2020/6/11 01:27
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionsHandler {

    /**
     * 功能描述：全局异常处理
     *
     * @param e
     * @return 返回处理结果
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommentResult errorHandler(Exception e) throws Exception {
        // 此处为属性级的错误日志的处理
        if (e instanceof ConstraintViolationException) {
            log.info("绑定错误日志为：{}", e.getMessage());
            return new CommentResult(500,"请求数据格式错误");
            // 此处为方法级别的错误日志处理
        } else if (e instanceof MethodArgumentNotValidException) {
            log.info("方法级的绑定错误日志为：{}", e.getMessage());
            return new CommentResult(500,"请求数据格式错误");
            // 此处为全局错误日志的处理
        } else {
            log.info("错误日志为：{}", e.getMessage());
            return new CommentResult(500,"全局异常错误给捕获了");
        }
    }

}

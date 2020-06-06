package com.i520java.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @PackageName:com.i520java.sentinel.controller
 * @ClassName:SentinelController
 * @author:金格[JIN_GE]
 * @date:2020/6/6 15:47
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@Slf4j
public class SentinelController {


    @GetMapping("/testA")
    public   String  testA(){
        return   "---------->test A!";
    }

    @GetMapping("/testB")
    public   String  testB(){
        log.info("----------->处理请求");
        return   "---------->test B!";
    }

    @GetMapping("/testC")
    public   String  testC(){
        try {
            Thread.sleep(1000); //睡眠1秒 模拟处理时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("----------->处理请求");
        return   "---------->test C!";
    }

    @GetMapping("/testD")
    public   String  testD(){
        log.info("----------->处理请求");
        int num=new Random().nextInt(2); //产生0-1之间的随机数
        int a=10/num; //只要是0就会异常

        return   "---------->test D!";
    }









    @GetMapping("/testHotKey")
    // value 就是资源命名(唯一ID) blockHandler被热点限流后的处理方法
    @SentinelResource(value = "testHotKey",blockHandler = "hotKey_blockHandler")
    public  String testHotKey(String p0, String p1){
        return   "------》testHotKey！参数p0:"+p0+",p1:"+p1;
    }

    public  String hotKey_blockHandler(String p0, String p1, BlockException e){
        return  "------>请求被热点限流参数p0:"+p0+",p1:"+p1;
    }


}

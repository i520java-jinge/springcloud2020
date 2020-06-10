package com.i520java.sentinel.controller.flowlimithander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.i520java.springcloud.comments.CommentResult;

/**
 * @PackageName:com.i520java.sentinel.controller.flowlimithander
 * @ClassName:MyHandler
 * @author:金格[JIN_GE]
 * @date:2020/6/7 23:24
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
public class MyHandler {

    //编写处理方法 注意方法必须是static修饰
    public static CommentResult  globalHandler(BlockException  e){
        return   new CommentResult(444,"全局限流处理:"+e.getClass());
    }

    //可以继续添加处理方法
}

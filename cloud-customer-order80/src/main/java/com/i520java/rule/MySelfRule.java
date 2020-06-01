package com.i520java.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @PackageName:com.i520java.springcloud.rule
 * @ClassName:MySelfRule
 * @author:金格[JIN_GE]
 * @date:2020/5/23 16:27 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */

@Configuration
public class MySelfRule{
    @Bean
    public IRule myRule(){
        return new I520JavaTestRule();// 随机算法
    }
}

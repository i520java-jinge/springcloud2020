package com.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @PackageName:com.cloud.gateway.filter
 * @ClassName:ParamFilter
 * @author:金格[JIN_GE]
 * @date:2020/6/2 18:01
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 */
@Component
@Slf4j
public class ParamFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("--------------->已经进入到gateway的过滤器ParamFilter");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            log.info("-------->uname参数为null，非法操作!");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

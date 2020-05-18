package com.i520java.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author 金格[JIN_GE]
 * @since 2020-04-29 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /*
     * 添加lombok 依赖 
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.4</version>
      </dependency>
    */
    private static final long serialVersionUID = 199870498497860749L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 流水号
    */
    private String serial;



}
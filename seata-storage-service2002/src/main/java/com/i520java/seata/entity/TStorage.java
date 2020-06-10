package com.i520java.seata.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TStorage)实体类
 *
 * @author 金格[JIN_GE]
 * @since 2020-06-08 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TStorage implements Serializable {
    /*
     * 添加lombok 依赖 
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.4</version>
      </dependency>
    */
    private static final long serialVersionUID = 764098596267149848L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 商品id
    */
    private Long productId;
    /**
    * 总库存
    */
    private Long total;
    /**
    * 已用库存
    */
    private Integer used;
    /**
    * 剩余库存
    */
    private Double residue;



}
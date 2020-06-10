package com.i520java.seata.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TOrder)实体类
 *
 * @author 金格[JIN_GE]
 * @since 2020-06-08 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TOrder implements Serializable {
    /*
     * 添加lombok 依赖 
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.4</version>
      </dependency>
    */
    private static final long serialVersionUID = 744745297325680206L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 商品id
    */
    private Long productId;
    /**
    * 数量
    */
    private Integer count;
    /**
    * 价格
    */
    private Double money;
    /**
    * 状态 0创建 1完成
    */
    private Integer status;



}
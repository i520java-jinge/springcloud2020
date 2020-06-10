package com.i520java.seata.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TAccount)实体类
 *
 * @author 金格[JIN_GE]
 * @since 2020-06-08 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TAccount implements Serializable {
    /*
     * 添加lombok 依赖 
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.4</version>
      </dependency>
    */
    private static final long serialVersionUID = -78519637015047528L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 总额度
    */
    private Double total;
    /**
    * 已用余额
    */
    private Double used;
    /**
    * 剩余可用余额
    */
    private Double residue;



}
package com.i520java.springcloud.entity;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author 金格[JIN_GE]
 * @since 2020-04-29 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = 919963618115584055L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 流水号
    */
    private String serial;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}
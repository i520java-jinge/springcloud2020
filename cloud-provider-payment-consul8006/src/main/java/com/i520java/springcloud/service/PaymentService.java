package com.i520java.springcloud.service;

import com.i520java.springcloud.entity.Payment;
import com.i520java.springcloud.i520java.util.I520JavaPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;


/**
 * (Payment)表业务服务接口
 *
 * @author makejava
 * @since 2020-04-29 19:45:00
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment getById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Payment> getAllByLimit(int offset, int limit);
    
    
     /**
     * 分类查询多条数据
     *
     * @param pageIndex 当前页码
     * @param pageSize 每页显示数据量
     * @return 对象列表
     */
    I520JavaPage<List<Payment>> getI520JavaPageByPayment(Payment  payment,Integer pageIndex,Integer pageSize);
    
 
    /**
     * 基于PageHelper分类查询多条数据
     * 1：pom.xml 依赖
        <!-- pagehelper分页插件依赖 -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.5</version>
        </dependency>
        2：配置文件application.yml
        pagehelper:
          helper-dialect: mysql
          reasonable: true
          support-methods-arguments: true
          params: count=countsql
     * @param pageIndex 当前页码
     * @param pageSize 每页显示数据量
     * @return 对象列表
     */
     PageInfo getPageHelperByPayment(Payment  payment,Integer pageIndex,Integer pageSize);   
    
    
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
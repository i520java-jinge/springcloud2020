package com.i520java.springcloud.service.impl;

import com.i520java.springcloud.entity.Payment;
import com.i520java.springcloud.dao.PaymentDao;
import com.i520java.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import com.i520java.springcloud.i520java.util.I520JavaPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * (Payment)表业务服务实现类
 *
 * @author makejava
 * @since 2020-04-29 20:32:09
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment getById(Integer id) {
        return this.paymentDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Payment> getAllByLimit(int offset, int limit) {
        return this.paymentDao.selectAllByLimit(offset, limit);
    }
    
    
     /**
     * 分类查询多条数据
     *
     * @param pageIndex 当前页码
     * @param pageSize 每页显示数据量
     * @return 对象列表
     */
    public I520JavaPage<List<Payment>> getI520JavaPageByPayment(Payment  payment,Integer pageIndex,Integer pageSize){
        
        I520JavaPage<List<Payment>> page=new I520JavaPage<List<Payment>>(pageIndex,pageSize);
        
        Map<String,Object>  mapParam=new HashMap<String,Object>();
     mapParam.put("id",payment .getId());
       mapParam.put("serial",payment .getSerial());
          
        page.setCount(this.paymentDao.selectCountByMapParam(mapParam));
        
        int startIndex=(page.getPageIndex()-1)*page.getPageSize();
        List<Payment>  list= this.paymentDao.selectByMapParam(mapParam);  
        page.setData(list);
        return  page;    
    }
    
 
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
     * @return PageInfo对象
     */
     public PageInfo getPageHelperByPayment(Payment  payment,Integer pageIndex,Integer pageSize){
        PageHelper.startPage(pageIndex,pageSize);
         List<Payment>  list= this.paymentDao.selectAll(payment);  
         PageInfo pageInfo=new PageInfo(list);
         return pageInfo;
     }  
    
    
    

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insert(Payment payment) {
        int count=this.paymentDao.insert(payment);
        if(count>0)
        return payment;
        else return null;
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment update(Payment payment) {
        int count=this.paymentDao.update(payment);
        if(count>0)
        return this.getById(payment.getId());
         else return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.paymentDao.deleteById(id) > 0;
    }
}
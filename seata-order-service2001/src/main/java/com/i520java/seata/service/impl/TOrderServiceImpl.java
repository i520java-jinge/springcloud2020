package com.i520java.seata.service.impl;

import com.i520java.seata.entity.TOrder;
import com.i520java.seata.dao.TOrderDao;
import com.i520java.seata.service.FeignTAccountService;
import com.i520java.seata.service.FeignTStorageService;
import com.i520java.seata.service.TOrderService;
import com.i520java.springcloud.comments.CommentResult;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * (TOrder)表业务服务实现类
 *
 * @author makejava
 * @since 2020-06-08 16:36:50
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Service("tOrderService")
@Slf4j
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private TOrderDao tOrderDao;


    //feign 库存远程调用接口
    @Resource
    private FeignTStorageService feignTStorageService;

    //feign 账户远程调用接口
    @Resource
    private FeignTAccountService  feignTAccountService;



    

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    @GlobalTransactional(name = "i520java-create-order",rollbackFor ={Throwable.class,Exception.class})
    public CommentResult insert(TOrder tOrder) {

        log.info("--------【start】--->创建新订单！");
        tOrder.setStatus(0); //状态改为新创建 //0 创建 1 完成
        int count=this.tOrderDao.insert(tOrder);
        log.info("--------【end】--->创建新订单！");


        log.info("--------【start】--->远程调用【减库存】！");
        CommentResult decreaseStorage = feignTStorageService.decrease(tOrder.getProductId(), tOrder.getCount());
        log.info("--------【end】---->远程调用【减库存】！");

        log.info("--------【start】--->远程调用【扣余额】！");
        CommentResult decreaseAccount = feignTAccountService.decrease(tOrder.getUserId(), tOrder.getMoney());
        log.info("--------【end】---->远程调用【扣余额】！");

        //扣款成功后修改状态
        if(decreaseAccount.getCode()==200) {
            log.info("--------【start】--->修改订单状态！");
            TOrder tOrder1 = new TOrder();
            tOrder1.setId(tOrder.getId());
            tOrder1.setStatus(1); //状态改为完成  //0 创建 1 完成
            int count1 = this.tOrderDao.update(tOrder);
            log.info("--------【end】--->修改订单状态！");
            tOrder.setStatus(tOrder1.getStatus());
        }
        if(count>0&&decreaseStorage.getCode()==200 && decreaseAccount.getCode()==200){
            return   new CommentResult(200,"下单成功！",tOrder);
        }
        return     new CommentResult(500,"下单失败！");
    }

}
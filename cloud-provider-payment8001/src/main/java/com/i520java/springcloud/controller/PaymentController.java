package com.i520java.springcloud.controller;

import com.github.pagehelper.PageInfo;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import com.i520java.springcloud.i520java.util.I520JavaPage;
import com.i520java.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-04-29 20:02:15
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/select/{id}")
    public Payment selectOne(@PathVariable("id") Integer id) {
        return this.paymentService.getById(id);
    }
    
    /**
     * @param  payment 实体类接收搜索条件
     * @param  pageIndex 当前页码
     * @param  pageSize  每页显示数据条数
     * @return I520JavaPage 分页对象
    */
    @GetMapping("/select/list")
    public I520JavaPage selectPageList(Payment payment , @RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "5")Integer pageSize) {
        return this.paymentService.getI520JavaPageByPayment(payment,pageIndex,pageSize);
    }
    
    /**
     * @param  payment 实体类接收搜索条件
     * @param  pageIndex 当前页码
     * @param  pageSize  每页显示数据条数
     * @return PageInfo 分页对象
    */
    @GetMapping("/select/list2")
    public PageInfo selectPageList2(Payment payment , @RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "5")Integer pageSize) {
        return this.paymentService.getPageHelperByPayment(payment,pageIndex,pageSize);
    }



    /**
     * 增加
     * @Author 金格[JIN_GE]
     * @Date 20:28 2020/4/29
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @PostMapping("/create")
    public CommentResult  create(Payment payment){
        payment = this.paymentService.insert(payment);
        if(payment!=null){
            log.info("************插入数据成功:");
            return  new CommentResult(200,"插入数据成功",payment);
        }else{
            log.info("************插入数据失败");
            return  new CommentResult(444,"插入数据失败");
        }

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommentResult getPayment(@PathVariable("id") Integer id) {

        Payment payment =this.paymentService.getById(id);
        if(payment!=null){
            log.info("************查询数据成功111:");
            return  new CommentResult(200,"查询数据成功",payment);
        }else{
            log.info("************查询数据失败");
            return  new CommentResult(444,"没有对应的数据，查询id："+id);
        }

    }




}
package com.i520java.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import com.i520java.springcloud.i520java.util.I520JavaPage;
import com.i520java.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    //服务发现
    @Resource
    private DiscoveryClient discoveryClient;

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
    public CommentResult  create(@RequestBody  Payment payment){
        payment = this.paymentService.insert(payment);
        if(payment!=null){
            log.info("************插入数据成功:当前端口："+serverPort);
            return  new CommentResult(200,"插入数据成功,当前端口："+serverPort,payment);
        }else{
            log.info("************插入数据失败");
            return  new CommentResult(444,"插入数据失败,当前端口："+serverPort);
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
            log.info("************查询数据成功,当前端口："+serverPort);
            return  new CommentResult(200,"查询数据成功,当前端口："+serverPort,payment);
        }else{
            log.info("************查询数据失败");
            return  new CommentResult(444,"没有对应的数据，查询id："+id+",当前端口："+serverPort);
        }

    }


    /**
     *服务发现
     * @Author 金格[JIN_GE]
     * @Date 13:43 2020/5/21
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/discovery")
    public  DiscoveryClient  getDiscoveryClient(){

        //日志记录服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services){
            log.info("----------------->"+service);
        }
        //获取指定服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance s :instances){
            log.info("----------------->Scheme:"+s.getScheme()+",Host:"+s.getHost()+",Port:"+s.getPort()+",uri:"+s.getUri());
        }
        return   discoveryClient;
    }


    /**
     * 演示超时方法
     * @Author 金格[JIN_GE]
     * @Date 16:59 2020/5/30
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/timeout/ex")
    public  String  timeoutEx(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "这是"+serverPort+"返回结果！";
    }


    /**
     * 成功响应
     * @Author 金格[JIN_GE]
     * @Date 16:49 2020/5/31
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/hystrix/success/{id}")
    public CommentResult getByIdForHystrixSuccess(@PathVariable("id") Integer id){

        Payment payment=this.paymentService.getByIdForHystrixSuccess(id);
        String tname=Thread.currentThread().getName();
        String info="************【controller----HystrixSuccess方法】查询数据成功,当前端口：【"+serverPort+"】线程是【"+tname+"】,id:【"+id+"】";
        log.info(info);
        return  new CommentResult(200,info,payment);

    }


    /**
     * 模拟延时超时响应
     * @Author 金格[JIN_GE]
     * @Date 16:50 2020/5/31
     * @Param
     * @return
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    @GetMapping("/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "getByIdForHystrixTimeOutHandler",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public CommentResult getByIdForHystrixTimeOut(@PathVariable("id") Integer id){
        Payment payment=this.paymentService.getByIdForHystrixTimeOut(id);
        String tname=Thread.currentThread().getName();
        String info="************Success【controller----HystrixTimeOut方法】查询数据成功,当前端口：【"+serverPort+"】线程是【"+tname+"】,id:【"+id+"】";
        log.info(info);
        return  new CommentResult(200,info,payment);
    }


    public CommentResult getByIdForHystrixTimeOutHandler(@PathVariable("id") Integer id){
        String tname=Thread.currentThread().getName();
        String info="************ Error【controller----HystrixTimeOut方法】查询数据失败,当前端口：【"+serverPort+"】线程是【"+tname+"】,id:【"+id+"】";
        return new CommentResult(500,info);
    }


    /**************[服务熔断演示]***************************/

    @GetMapping("/hystrix/circuit/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value = "true"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "10000"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "60")
    })
    public CommentResult  paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw   new RuntimeException("--------------->id参数不能为负数");
        }
        return   new CommentResult(200,"获取正常!","流水号:" +IdUtil.simpleUUID());
    }

    public CommentResult  paymentCircuitBreaker_fallBack(@PathVariable("id") Integer id){
        return   new CommentResult(500,"获取失败!id不能为负数！");
    }
}
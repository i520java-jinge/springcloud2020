package com.i520java.springcloud.controller;

import com.github.pagehelper.PageInfo;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.entity.Payment;
import com.i520java.springcloud.i520java.util.I520JavaPage;
import com.i520java.springcloud.service.PaymentService;
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


}
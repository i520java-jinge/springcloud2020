package com.i520java.rule;/**
 * date: 2020/5/23 16:35<br/>
 *
 * @author jinge<br />
 * @version
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * @since JDK 1.8
 */

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  这里模拟每个服务 必须被调用5次后才能换一个新的服务
 * @PackageName:com.i520java.rule
 * @ClassName:I520JavaTestRule
 * @author:金格[JIN_GE]
 * @date:2020/5/23 16:35 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public class I520JavaTestRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter; //原子类
    private static final boolean AVAILABLE_ONLY_SERVERS = true; //可用服务
    private static final boolean ALL_SERVERS = false; //所有服务
    private static Logger log = LoggerFactory.getLogger(I520JavaTestRule.class); //日志

    private static Map<String,Integer>  serverMap=new HashMap<>(); //记录当前服务被调用的次数
    private static int  nextServerIndex; //记录当前使用服务下标
    private static int  useTime=5; //每台服务调用的次数

    public I520JavaTestRule() {
        this.nextServerCyclicCounter = new AtomicInteger(0);
    }

    //获得负载均衡接口
    public I520JavaTestRule(ILoadBalancer lb) {
        this();
        this.setLoadBalancer(lb);
    }

    //获得服务
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        } else {
            Server server = null;
            int count = 0;

            while(true) {
                if (server == null && count++ < 10) {
                    List<Server> reachableServers = lb.getReachableServers(); //可用服务
                    List<Server> allServers = lb.getAllServers(); //获得所有服务
                    int upCount = reachableServers.size(); //可用服务数量
                    int serverCount = allServers.size(); //所有服务数量
                    if (upCount != 0 && serverCount != 0) {

                        nextServerIndex = getNextServerIndex(serverCount); //获得服务 下标
                        server = (Server)allServers.get(nextServerIndex);
                        if (server == null) {
                            Thread.yield();
                        } else {
                            if (server.isAlive() && server.isReadyToServe()) {
                                remindServerCount(nextServerIndex); //记录服务使用次数
                                //日志输出
                                String url=server.getScheme()+"://"+server.getHost()+":"+server.getPort();
                                log.info("------------>使用下标【"+nextServerIndex+"】url:【"+url+"】服务，第【"+serverMap.get("index-"+nextServerIndex)+"】次！");
                                return server;
                            }

                            server = null;
                        }
                        continue;
                    }

                    log.warn("No up servers available from load balancer: " + lb);
                    return null;
                }

                if (count >= 10) {
                    log.warn("No available alive servers after 10 tries from load balancer: " + lb);
                }

                return server;
            }
        }
    }

    /*
        自旋锁（spinlock）：是指当一个线程在获取锁的时候，如果锁已经被其它线程获取，那么该线程将循环等待，然后不断的判断锁是否能够被成功获取，直到获取到锁才会退出循环。
        自旋锁不会使线程状态发生切换，一直处于用户态，即线程一直都是active的；不会使线程进入阻塞状态，减少了不必要的上下文切换，执行速度快
        非自旋锁在获取不到锁的时候会进入阻塞状态，从而进入内核态，当获取到锁的时候需要从内核态恢复，需要线程上下文切换。
        （线程被阻塞后便进入内核（Linux）调度状态，这个会导致系统在用户态与内核态之间来回切换，严重影响锁的性能）
     */
    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();
            next = (current + 1) % modulo;
        } while(!this.nextServerCyclicCounter.compareAndSet(current, next));

        return next;
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    public  void   remindServerCount(int nextServerIndex){
        boolean  has=serverMap.containsKey("index-"+nextServerIndex);
        int  count=1;
        if(has) {
            count+=serverMap.get("index-"+nextServerIndex);
        }
        serverMap.put("index-" + nextServerIndex, count);
    }


    //获得服务下标 不满useTime 次数的返回原来的 满可就换新的
    public int getNextServerIndex(int serverCount){
        boolean  has=serverMap.containsKey("index-"+nextServerIndex);
        if(has){
            int count=serverMap.get("index-"+nextServerIndex)%useTime;
            if(count!=0){
                return  nextServerIndex;
            }else{
                serverMap.remove("index-"+nextServerIndex);
            }
        }
        return this.incrementAndGetModulo(serverCount);
    }
}

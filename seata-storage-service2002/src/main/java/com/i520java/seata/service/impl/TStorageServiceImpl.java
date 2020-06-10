package com.i520java.seata.service.impl;

import com.i520java.seata.entity.TStorage;
import com.i520java.seata.dao.TStorageDao;
import com.i520java.seata.service.TStorageService;
import com.i520java.springcloud.comments.CommentResult;
import com.i520java.springcloud.util.I520JavaPage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * (TStorage)表业务服务实现类
 *
 * @author makejava
 * @since 2020-06-08 20:27:01
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
@Service("tStorageService")
@Slf4j
public class TStorageServiceImpl implements TStorageService {
    @Resource
    private TStorageDao tStorageDao;


    //减库存
    @Override
    public CommentResult  decrease(Long productId, Integer count){

        //由于dao是自动生成的 没有根据productId 查询商品的方法 且productId 又不是主键。
        //所有使用我下面方式查询
        Map<String,Object> param=new HashMap<>();
        param.put("productId",productId);

        TStorage tStorage= tStorageDao.selectByMapParam(param).get(0);

        if(tStorage==null){
            return  new CommentResult(400,"该商品库存不存在!");
        }
        //修改
        tStorage.setTotal(tStorage.getTotal()-count); //减总数
        tStorage.setUsed(tStorage.getUsed()+count); //加使用库存
        tStorage.setResidue(tStorage.getResidue()-count); //余量

        int count1=tStorageDao.update(tStorage);
        if(count1>0){
            return   new CommentResult(200,"减库存操作成功！",tStorage);
        }
        return   new CommentResult(400,"减库存操作失败！");
    }


    @Override
    public CommentResult getStorage(Long id) {

        TStorage tStorage = tStorageDao.selectById(id);
        if(tStorage!=null){
            return   new CommentResult(200,"查询库存success!",tStorage);
        }
        return  new CommentResult(400,"该商品库存不存在!");
    }
}
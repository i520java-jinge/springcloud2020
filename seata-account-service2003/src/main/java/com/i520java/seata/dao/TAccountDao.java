package com.i520java.seata.dao;

import com.i520java.seata.entity.TAccount;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (TAccount)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:12:02
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public interface TAccountDao {

    /**
     * 通过ID查询单条数据
     * 
     * @param id 主键
     * @return 实例对象
     */
    TAccount selectById(Long id);

    /**
     * 查询指定行数据
     *
     * @param startIndex 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TAccount> selectAllByLimit(@Param("startIndex") int startIndex, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAccount 实例对象
     * @return 对象列表
     */
    List<TAccount> selectAll(TAccount tAccount);
    
    
      /**
     * 通过自定义参数作为筛选条件查询
     * 默认这已经将所有实体类属性作为筛选条件
     * 如果有其他特殊的需要自己修改文件
     * @param mapParam 自定义参数对象 
     *                 默认已经将【TAccount】实体的所有属性作为条件不传递查询所有
                       以及分页参数，map添加key为"startIndex" 开始位置  key为"limit" 限制行数
     * @return 对象列表
     */
    List<TAccount> selectByMapParam(Map<String,Object> mapParam);
    
     
    /**
     * 通过自定义参数作为筛选条件查询
     * 默认这已经将所有实体类属性作为筛选条件
     * 如果有其他特殊的需要自己修改文件
     * @param mapParam 自定义参数对象 
     *                 默认已经将【TAccount】实体的所有属性作为条件不传递查询所有
                       以及分页参数，map添加key为"startIndex" 开始位置  key为"limit" 限制行数
     * @return 统计的结果
     */
    int selectCountByMapParam(Map<String,Object> mapParam);
    
        
        
    
    /**
     * 新增数据
     *
     * @param tAccount 实例对象
     * @return 影响行数
     */
    int insert(TAccount tAccount);

    /**
     * 修改数据
     *
     * @param tAccount 实例对象
     * @return 影响行数
     */
    int update(TAccount tAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
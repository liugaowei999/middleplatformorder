package com.ly.traffic.middleplatform.domain.createorder.repository.mapper;

import com.ly.traffic.middleplatform.domain.createorder.repository.po.MainOrderPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 主订单表(MainOrderPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 14:11:28
 */
public interface MainOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MainOrderPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MainOrderPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mainOrderPO 实例对象
     * @return 对象列表
     */
    List<MainOrderPO> queryAll(MainOrderPO mainOrderPO);

    /**
     * 新增数据
     *
     * @param mainOrderPO 实例对象
     * @return 影响行数
     */
    int insert(MainOrderPO mainOrderPO);

    /**
     * 修改数据
     *
     * @param mainOrderPO 实例对象
     * @return 影响行数
     */
    int update(MainOrderPO mainOrderPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

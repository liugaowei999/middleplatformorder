package com.ly.traffic.middleplatform.domain.cancelorder.repository.mapper;

import com.ly.traffic.middleplatform.domain.cancelorder.repository.po.CancelOrderPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 取消订单订单表(CancelOrderPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-24 19:37:10
 */
public interface CancelOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CancelOrderPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CancelOrderPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param cancelOrderPO 实例对象
     * @return 对象列表
     */
    List<CancelOrderPO> queryAll(CancelOrderPO cancelOrderPO);

    /**
     * 新增数据
     *
     * @param cancelOrderPO 实例对象
     * @return 影响行数
     */
    int insert(CancelOrderPO cancelOrderPO);

    /**
     * 修改数据
     *
     * @param cancelOrderPO 实例对象
     * @return 影响行数
     */
    int update(CancelOrderPO cancelOrderPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

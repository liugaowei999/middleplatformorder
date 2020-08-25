package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.PayOrderInfoPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 支付任务订单表(PayOrderInfoPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-25 18:22:07
 */
public interface PayOrderInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PayOrderInfoPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PayOrderInfoPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param payOrderInfoPO 实例对象
     * @return 对象列表
     */
    List<PayOrderInfoPO> queryAll(PayOrderInfoPO payOrderInfoPO);

    /**
     * 新增数据
     *
     * @param payOrderInfoPO 实例对象
     * @return 影响行数
     */
    int insert(PayOrderInfoPO payOrderInfoPO);

    /**
     * 修改数据
     *
     * @param payOrderInfoPO 实例对象
     * @return 影响行数
     */
    int update(PayOrderInfoPO payOrderInfoPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

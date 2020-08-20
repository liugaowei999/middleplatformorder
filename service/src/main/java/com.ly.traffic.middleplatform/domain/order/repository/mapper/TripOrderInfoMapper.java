package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.TripOrderInfoPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单出行信息表(TripOrderInfoPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public interface TripOrderInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TripOrderInfoPO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TripOrderInfoPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tripOrderInfoPO 实例对象
     * @return 对象列表
     */
    List<TripOrderInfoPO> queryAll(TripOrderInfoPO tripOrderInfoPO);

    /**
     * 新增数据
     *
     * @param tripOrderInfoPO 实例对象
     * @return 影响行数
     */
    int insert(TripOrderInfoPO tripOrderInfoPO);

    /**
     * 修改数据
     *
     * @param tripOrderInfoPO 实例对象
     * @return 影响行数
     */
    int update(TripOrderInfoPO tripOrderInfoPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

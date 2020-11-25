package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.TripPassengerOrderInfoPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 乘客行程信息表(TripPassengerOrderInfoPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public interface TripPassengerOrderInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TripPassengerOrderInfoPO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TripPassengerOrderInfoPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tripPassengerOrderInfoPO 实例对象
     * @return 对象列表
     */
    List<TripPassengerOrderInfoPO> queryAll(TripPassengerOrderInfoPO tripPassengerOrderInfoPO);

    /**
     * 新增数据
     *
     * @param tripPassengerOrderInfoPO 实例对象
     * @return 影响行数
     */
    int insert(TripPassengerOrderInfoPO tripPassengerOrderInfoPO);

    /**
     * 修改数据
     *
     * @param tripPassengerOrderInfoPO 实例对象
     * @return 影响行数
     */
    int update(TripPassengerOrderInfoPO tripPassengerOrderInfoPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

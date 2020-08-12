package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.UMainOrderPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 主订单表(UMainOrderPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-07 17:29:26
 */
public interface MainOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UMainOrderPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UMainOrderPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param UMainOrderPO 实例对象
     * @return 对象列表
     */
    List<UMainOrderPO> queryAll(UMainOrderPO UMainOrderPO);

    /**
     * 新增数据
     *
     * @param UMainOrderPO 实例对象
     * @return 影响行数
     */
    int insert(UMainOrderPO UMainOrderPO);

    /**
     * 修改数据
     *
     * @param UMainOrderPO 实例对象
     * @return 影响行数
     */
    int update(UMainOrderPO UMainOrderPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

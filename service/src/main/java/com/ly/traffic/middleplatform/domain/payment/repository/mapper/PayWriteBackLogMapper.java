package com.ly.traffic.middleplatform.domain.payment.repository.mapper;

import com.ly.traffic.middleplatform.domain.payment.repository.po.PayWriteBackLogPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 支付回写记录表(PayWriteBackLogPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-25 18:43:40
 */
public interface PayWriteBackLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PayWriteBackLogPO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PayWriteBackLogPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param payWriteBackLogPO 实例对象
     * @return 对象列表
     */
    List<PayWriteBackLogPO> queryAll(PayWriteBackLogPO payWriteBackLogPO);

    /**
     * 新增数据
     *
     * @param payWriteBackLogPO 实例对象
     * @return 影响行数
     */
    int insert(PayWriteBackLogPO payWriteBackLogPO);

    /**
     * 修改数据
     *
     * @param payWriteBackLogPO 实例对象
     * @return 影响行数
     */
    int update(PayWriteBackLogPO payWriteBackLogPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
